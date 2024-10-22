package org.example.Util;

import java.util.concurrent.Semaphore;

public class FormatterUtil {

    public static String formatterTelefon( String mobil ) {
        String regexMobil = "(\\d{3})(\\d{2})(\\d+)";
        return mobil.replaceFirst(regexMobil,"$1 $2 $3"); //### ## ###
    }
    

}
