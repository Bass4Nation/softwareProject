package hiof.findParking.repository;


//import no.hiof.kristoss.oblig6.model.Animal;
//import no.hiof.kristoss.oblig6.model.Location;
//import no.hiof.kristoss.oblig6.model.Observation;

import hiof.findParking.model.Annonse;

import java.util.List;

public interface IRepository {

    List<Annonse> getAllInfo();
    Annonse getInfo(String stedId);
//    Object createAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments );
//    Object updateAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments );
//    Object deleteAObservation(String stedId, String filNavn);
//



}