package org.example.Util;

public class ValidatorUtil {


    public static boolean erGyldigFornavn(String t){

        String regex = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]{2,20}$";
        return t.matches(regex);
    }

    public static boolean erGyldigEtternavn(String t) {
        String regex = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{2,20}$";
        return t.matches(regex);
    }
    public static boolean erGylidgMobil(String t){
        String regex = "^[0-9]{8}$";
        return t.matches(regex);
    }

    public static boolean erGyldigPassord(String t){
        String regex = "^(?=.*[A-Z])(?=.*\\d).{6,}$"; //Passord må vøre minst 6 bokstaver, Inneholde 1 stor bokstav og ett tall
        return t.matches(regex);
    }
    public static boolean erGyldigPassordRepetert(String passord, String passordRepetert){

        return passord.equals(passordRepetert);
    }


    public static boolean erGyldigKjonn(String t) {
        String regex = "([Mm]ann)|([Kk]vinne)";
        return t.matches(regex);
    }

    public static boolean valideringAlleInput(String fornavn, String etternavn, String mobil, String passord,
                                              String passordRepetert, String kjonn){


        return erGyldigFornavn(fornavn) && erGyldigEtternavn(etternavn) && erGylidgMobil(mobil) &&
                erGyldigPassord(passord) && erGyldigPassordRepetert(passord,passordRepetert)
                && erGyldigKjonn( kjonn);


    }




}
