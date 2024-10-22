package org.example.Model;

import jakarta.persistence.*;
import static org.example.Util.FormatterUtil.*;

@Entity
@Table(name="deltager", schema = "dat108_oblig4")
public class Deltager {



    @Id private String mobil;

   @Embedded private Passord passord;

    private String fornavn;
    private String etternavn;
    private String kjonn;

    public Deltager(){}

    public Deltager(String mobil, String fornavn, String etternavn, String kjonn) {
        this.mobil = mobil;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getKjonn() {
        return kjonn;
    }

    public Passord getPassord(){ return passord; }


    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setPassord(Passord passord) {
        this.passord = passord;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
    @Override
    public String toString() {
        return "Deltager[" +
                "mobil='" + mobil + '\'' +
                ", passord=" + passord +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", kjonn='" + kjonn + '\'' +
                ']';
    }

    //For og formattere mobil fra ######## -> ### ## ### når vi skriver ut deltagerlisten i deltagerliste.jsp
    public String formatterNr(){return formatterTelefon(mobil);}
}
