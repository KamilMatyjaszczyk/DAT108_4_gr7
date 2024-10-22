import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Util.ValidatorUtil.*;
import static org.example.Util.FormatterUtil.*;
import static org.junit.jupiter.api.Assertions.*;

public class Validator_Formattering_TEST {

    String[] feil;
    String[] riktig;

    @BeforeEach
    void reset(){
        feil = new String[]{};
        riktig = new String[]{};
    }


    @Test
    void fornavnTest(){
        feil = new String[]{"r", "per", "stringsomerovertjuebokstaver", "D0nald gl0ver"};
        riktig = new String[]  {"Tom ","Åge","Geir-Ronny","Jay-Z","Kanye ye"};

        for(String navn : feil)
            assertFalse(erGyldigFornavn(navn));

        for(String navn : riktig)
            assertTrue(erGyldigFornavn(navn));
    }

    @Test
    void etternavnTest(){
        feil = new String[]{"etternavn", "Kåre kåre", "Arnes3n","stringsomerovertjuebokstaver","kø"};
        riktig = new String[]{"Etternavn", "Ronny-Jhonsen", "Eggen"};

        for(String navn : feil)
            assertFalse(erGyldigEtternavn(navn));

        for(String navn : riktig)
            assertTrue(erGyldigEtternavn(navn));
    }

    @Test
    void mobilTest(){
        feil = new String[]{"123456","123456789","EnToTreFireFemSeksSjuÅtte"};
        riktig = new String[]{"12345678", "45678921"};

        for(String nummer : feil)
            assertFalse(erGylidgMobil(nummer));

        for(String nummer : riktig)
            assertTrue(erGylidgMobil(nummer));
    }

    @Test
    void passordTest(){
        feil = new String[]{"passord","Pass1","veldilangtpassordutenstorbokstavogtall"};
        riktig = new String[]{"Passord1", "veldigSterktPassordMedFlereStoreBokstaverOgEtTall5"};

        for(String passord : feil)
            assertFalse(erGyldigPassord(passord));

        for(String passord : riktig)
            assertTrue(erGyldigPassord(passord));
    }
    @Test
    void kjonnTest(){
        feil = new String[]{"kjønn","hen","they","them","ze","zem"};
        riktig = new String[]{"mann", "kvinne","Mann","Kvinne"};

        for(String kjonn : feil)
            assertFalse(erGyldigKjonn(kjonn));

        for(String kjonn : riktig)
            assertTrue(erGyldigKjonn(kjonn));
    }

    @Test
    void fomrateringTelefon(){
       String tlf = "12345678";
       String riktig = "123 45 678";

       assertEquals(formatterTelefon(tlf),riktig);
       assertNotEquals(formatterTelefon(tlf),tlf);
    }

}
