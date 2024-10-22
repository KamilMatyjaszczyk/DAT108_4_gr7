package org.example.Component;

import org.example.Model.Passord;
import org.example.Service.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/*
Trenger denne klassen sånn at SPRING klarer å convertere fra passord til String
Får denne feilmeldingen hvis ikke

 "Cannot convert value of type 'java.lang.String'
 to required type 'org.example.Model.Passord' for property 'passord':
 no matching editors or conversion strategy found"

*/

@Component
public class StringToPassordConverter implements Converter<String, Passord> {

    @Autowired
    PassordService passordService;

    @Override
    public Passord convert(String passordString) {

        Passord passord = new Passord();
        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(passordString, salt);

        passord.setHash(hash);
        passord.setSalt(salt);

        return passord;

    }

}
