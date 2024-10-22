package org.example.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.Model.Deltager;

public class LoginUtil {


    public static void loggUtBruker(HttpSession session) {
        session.invalidate();
    }


    public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {

        loggUtBruker(request.getSession());

        HttpSession session = request.getSession(true);
        session.setAttribute("deltager",deltager);
    }

    public static boolean erBrukerInnlogget(HttpSession session) {

        return session!=null && session.getAttribute("deltager")!=null;
    }
}
