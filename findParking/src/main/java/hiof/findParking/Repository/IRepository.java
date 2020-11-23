package hiof.findParking.Repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;

import java.util.List;

public interface IRepository {

    List<Alle_Annonser> getAlleAnnonser();
    Alle_Annonser getAlleAnnonse(String AlleAnnonseName);
    Alle_Annonser getAnnonserFylke(String AlleAnnonseName);
    Annonse getAnnonse(String AlleAnnonseName, String id);
    List<Annonse> getAnnonser(String AlleAnnonseName);


}