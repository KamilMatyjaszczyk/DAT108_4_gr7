package org.example.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.Util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/logut")
public class LogutController {


    @PostMapping()
    public String postUtlogging(HttpSession session, RedirectAttributes ra) {

        //På en flash attribute så blir "melding automatisk lagt til i en model"
        ra.addFlashAttribute("melding", "Du er logget ut");

        //Avslutter brukeren sin session
        LoginUtil.loggUtBruker(session);

        return "redirect:innlogging";
    }
}
