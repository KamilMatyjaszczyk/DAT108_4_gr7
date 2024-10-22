package org.example.Model;

import jakarta.persistence.Embeddable;


@Embeddable
public class Passord {
    private String hash;
    private String salt;


    public Passord() {}

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setHash(String hash) {this.hash = hash;}

    public void setSalt(String salt) {this.salt = salt;}
}
