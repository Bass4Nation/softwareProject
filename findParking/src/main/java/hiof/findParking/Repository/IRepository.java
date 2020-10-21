package hiof.findParking.Repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import java.util.List;

public interface IRepository {

    List<Observation> getAllInfo();
    Observation getInfo(String stedId);
    Object createAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments );
    Object updateAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments );
    Object deleteAObservation(String stedId, String filNavn);




}