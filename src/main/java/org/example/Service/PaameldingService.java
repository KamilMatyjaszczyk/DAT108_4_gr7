package org.example.Service;

import org.example.Repository.DeltagerRepo;
import org.example.Model.Deltager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PaameldingService {

    @Autowired private DeltagerRepo deltagerRepo;



    public Deltager nyDeltager(@ModelAttribute("deltager") Deltager deltager){
        deltagerRepo.save(deltager);
        return deltager;
    }


    public List<Deltager> finnAlleDeltagere(){
      List<Deltager> sortert = new ArrayList<>( deltagerRepo.findAll());
      //Sorterer først på fornavn også etternavn
      sortert.sort(Comparator.comparing(a -> (a.getFornavn() + a.getEtternavn())));
      return sortert;
    }

    public Deltager finnDeltagerId(String id){return  deltagerRepo.getReferenceById(id);}

    public Boolean eksistererDeltager(String id){return deltagerRepo.existsById(id);}



}
