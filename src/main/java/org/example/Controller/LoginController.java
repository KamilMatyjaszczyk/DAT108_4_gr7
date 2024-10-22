package org.example.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.Model.Deltager;
import org.example.Service.PaameldingService;
import org.example.Service.PassordService;
import org.example.Util.LoginUtil;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/innlogging")
public class LoginController {

    @Autowired
    private PaameldingService paameldingService;

    @Autowired
    private PassordService passordService;


    @GetMapping()
    public String getUtlogging() {
        return "innlogging";
    }

    @PostMapping
    public String postInnlogging(@RequestParam(name = "mobil")String mobil,
                                 @RequestParam(name="passord")String passordInput,
                                 HttpServletRequest request, RedirectAttributes ra) {

        //Hvis bruker ikke eksisterer i database
        if(!paameldingService.eksistererDeltager(mobil)) {
            ra.addFlashAttribute("melding","Ugyldig brukernavn og/eller passord");
            return "redirect:innlogging";
        }

        Deltager deltager = paameldingService.finnDeltagerId(mobil);

        //Finner ut om det er riktig passord eller ikke
        boolean riktigPassord = passordService
                .erKorrektPassord(passordInput,
                deltager.getPassord().getSalt(),
                deltager.getPassord().getHash());

        if(!riktigPassord){
            ra.addFlashAttribute("melding","Ugyldig brukernavn og/eller passord");
            return "redirect:innlogging";
        }

        //Lager en session for brukeren som logger inn
        LoginUtil.loggInnBruker(request,deltager);

        return "redirect:deltager";
    }

}
