package hiof.findParking.repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;

import java.util.ArrayList;

public interface IRepository {

    ArrayList<Alle_Annonser> getAlleAnnonser();
    Alle_Annonser getAlleAnnonse(String AlleAnnonseName);

}