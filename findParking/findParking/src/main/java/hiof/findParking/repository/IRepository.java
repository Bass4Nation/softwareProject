package hiof.findParking.repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface IRepository {

    //ArrayList<Alle_Annonser> getAlleAnnonser();
    Alle_Annonser getAlleAnnonse(String AlleAnnonseName);
    Annonse getAnnonse(String planetSystemName, String id);
    ArrayList<Annonse> getAnnonser(String AlleAnnonseName);
    List<Alle_Annonser> fileReader(String fileGet);
    List<Alle_Annonser> getAlleAnnonser();
    Object createAnnonse (String filename, String adresse, String navn, String beskrivelse, String name, int pris, String pictureUrl);




}