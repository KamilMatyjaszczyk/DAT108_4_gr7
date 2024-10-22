package org.example.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.Model.Deltager;
import org.example.Model.Passord;
import org.example.Service.PaameldingService;
import org.example.Service.PassordService;

import static org.example.Util.ValidatorUtil.*;
import static org.example.Util.LoginUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/paamelding")
public class PaameldingController {


    @Autowired
    private PaameldingService paameldingService;
    @Autowired
    private PassordService passordService;





    /*
    Trenger ingen Model model, eller RedirectAttributes ra i parameter fordi alle
    feilmeldingene blir sendt fra post som en flashAttribute. Dermed blir melidngene automatisk
     lagt til model som blir sendt videre fra redirect til get metoden som gjør til at vi får
     tak i denne modellen i JSP filen
     */

    //PåmeldingsSKJEMA
    @GetMapping
    public String startside() {
        return "paamelding";
    }


    @PostMapping()
    public String postSkjema(@Valid @ModelAttribute("deltager") Deltager deltager, HttpServletRequest request,
                             @RequestParam(name = "passord") String passordInput,
                             @RequestParam(name = "passordRepetert") String passordRepetert, RedirectAttributes ra) {


        //VALIDERING
        if (!valideringAlleInput(deltager.getFornavn(), deltager.getEtternavn(),
                deltager.getMobil(), passordInput, passordRepetert, deltager.getKjonn())) {

            ra.addFlashAttribute("error", "Ugyldig brukerinput");
            return "redirect:paamelding";

            //Hvis nummeret eksisterer fra før
        }else if (paameldingService.eksistererDeltager(deltager.getMobil())) {
            ra.addFlashAttribute("error", "Bruker med dette nummeret eksisterer allerede");
            return "redirect:paamelding";
        }

        //PASSORD
        Passord passord = new Passord();
        passord.setSalt(passordService.genererTilfeldigSalt());
        passord.setHash(passordService.hashMedSalt(passordInput, passord.getSalt()));
        deltager.setPassord(passord);

        //Lager en session for en bruker som registrerer seg
        loggInnBruker(request, deltager);
        return "redirect:paamelding/paameldt";
    }

    //Kvittering for godkjent påmelding
    @GetMapping("/paameldt")
    public String lagBruker(HttpSession session, Model model) {

        //Henter ut deltager d som vi laget under "paamelding"
        Deltager d = (Deltager) session.getAttribute("deltager");

        //Legger til deltager "d" i modellen "deltager"
        model.addAttribute("deltager", d);
        //Legger til deltager d i databasen
        paameldingService.nyDeltager(d);
        return "paameldt";
    }


}




