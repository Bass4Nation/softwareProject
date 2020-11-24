package hiof.findParking.repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;

import java.util.ArrayList;
import java.util.List;

public interface IRepository {

    List<Alle_Annonser> getAlleAnnonser();
    List<Annonse> getAlleAnnonse(String AlleAnnonseName, String sortBy);
    Alle_Annonser getAnnonserFylke(String AlleAnnonseName);
    Annonse getAnnonse(String AlleAnnonseName, String id);
    List<Annonse> getAnnonser(String AlleAnnonseName);


}