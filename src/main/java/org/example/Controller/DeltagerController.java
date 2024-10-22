package org.example.Controller;

import static org.example.Util.LoginUtil.erBrukerInnlogget;
import jakarta.servlet.http.HttpSession;
import org.example.Model.Deltager;
import org.example.Service.PaameldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/deltager")
public class DeltagerController {

    @Autowired
    private PaameldingService paameldingService;

    @GetMapping()
    public String getDeltager(Model model, HttpSession session, RedirectAttributes ra) {

        //Henter deltager fra brukeren sin session
        Deltager d = (Deltager) session.getAttribute("deltager");

        //Hvis man prøver å skrive localhost8080/deltager
        if(!erBrukerInnlogget(session)){
            ra.addFlashAttribute("melding","Du er logget ut");
            return "redirect:/logut";
        }
        //Henter tabellen av alle deltagere
        model.addAttribute("liste",paameldingService.finnAlleDeltagere());

        //Henter deltager d som vi laget tidligere
        model.addAttribute("deltager",d);

        return "deltagerliste";
    }



}
