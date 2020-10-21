package hiof.findParking.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.kristoss.oblig6.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Repository implements IRepository {
//    Velger å bruke List siden den passer best til det jeg har kodet før. Og jeg kan mest om det
//    enn Map eller andre måter å lagre informasjon. Så det er derfor jeg bruker List

    //    public List<Observation> obsListe = new ArrayList<>(); // ------------- For å lage en JSON fil.
    public List<Observation> obsListe = leseFraJson("ObsList.json");

    // -------- Har repository Under her for å lage Json filen -------------------------------
    public Repository() {

        //----------------------- Lager dyrene først så inn i observasjoner
//------------------------------------------------------ Animals ----------------------------
        Birds piggeot = new Birds("Piggeot",2,2,1, 40);
        Birds sikbil = new Birds("Sikbil",4,4,2, 21);
        Birds blaapeseo = new Birds("Blaapeseo",0,2,2, 10);
        Amphibians apoda = new Amphibians("Apoda", 0,0,10,5,true);
        Amphibians hydraSnake = new Amphibians("Hydra The Snake", 0,8,4,12, false);
        Amphibians crazyFrog = new Amphibians("CrazyFrog", 0,2,1,12, true);
        Invertebrates crabStick = new Invertebrates("Crab Stick crab", 12,10,3,1,true);
        //--------------------------------- Observation -----------------------------------------------
        Observation one = new Observation("vannpytt",piggeot, new Location(1.3245,-1.0097, "Tundra"), piggeot.getNumbersOfCreature(),16,4,2020,12,56,10,"https://cdn.bulbagarden.net/upload/5/57/018Pidgeot.png"," Earth", "Dette er kommentar som er for denne observasjonen");
        Observation two = new Observation("busk",sikbil, new Location(-1.9999,1.42452, "Forest"), sikbil.getNumbersOfCreature(),17,4,2020,12,56,10,"","Kelper-13", "Dette er kommentarer");
        Observation three = new Observation("tree west",blaapeseo, new Location(1.354855,-3.5779, "Forest"), blaapeseo.getNumbersOfCreature(),18,4,2020,12,56,10,"","Mars", "Dette er kommentarer");
        Observation four = new Observation("lake",apoda, new Location(1.123,1.12313, "Forest"), apoda.getNumbersOfCreature(),19,4,2020,12,56,10, "https://i.pinimg.com/originals/d2/02/25/d202259c624604e7c72cfae762aa62ab.jpg","Jupiter","Dette er kommentarer");
        Observation five = new Observation("river",hydraSnake, new Location(0.4435,-1.12313, "Forest"), hydraSnake.getNumbersOfCreature(),20,4,2020,12,56,10, "","Pluto","Dette er kommentarer");
        Observation six = new Observation("Moutain top",crazyFrog, new Location(1.7888,1.45533, "Moutain"), crazyFrog.getNumbersOfCreature(),21,4,2020,12,56,10,"https://w0.pngwave.com/png/744/57/crazy-frog-racer-2-crazy-background-png-clip-art.png","Venus","Dette er kommentarer");
        Observation seven = new Observation("cave",crabStick, new Location(-1.0034,-1.19978, "Forest"), crabStick.getNumbersOfCreature(),22,4,2020,12,56,10, "","Mars","Dette er kommentarer");

//        obsListe.add(one);
//        obsListe.add(two);
//        obsListe.add(three);
//        obsListe.add(four);
//        obsListe.add(five);
//        obsListe.add(six);
//        obsListe.add(seven);

    }

    public List<Observation> getAllInfo() {

//        File file = skriveTilJson("ObsList.json", obsListe);
//        ---------- Tenker det er naturlig å sortere etter Id --- Så går det i en rekkefølge ------------
//      3.2  c) Legg til en naturlig sortering i et par av klassene du tror det kan være aktuelt å kunne sortere.
//       Her Så velger jeg å sortere etter Animal name. Bare for å vise at den sorterer alfabetisk.
        obsListe.sort(Comparator.comparing(Observation::getAnimalName));
        return obsListe;
    }

    //    ---------- Hentet fra oblig 5 som jeg hadde -- Eneste lagt inn Observation ----
//    Velger å bruke Json siden det har jeg metoder fra min forje oblig.
//    Og liker det bedre en CSV og kan ikke XML.
    public static File skriveTilJson(String filnavn, List< Observation > liste) {
        File fil = new File(filnavn);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fil, liste);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fil;
    }

    public List<Observation> leseFraJson(String filnavn) {
        List<Observation> lesteObsJson = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Observation[] obsArray = objectMapper.readValue(new File(filnavn), Observation[].class);
            lesteObsJson = Arrays.asList(obsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lesteObsJson;
    }

    public Observation getInfo(String stedId) {

        for (Observation observation : obsListe) {
            if (observation.getName().equals(stedId))
                return observation;
        }
        return null;
    }

//    Får ikke testet CRUD, siden jeg har bare en vue side. Så har prøvd å tilpasse de som virket i oblig 5 (min versjon) til denne oppgaven.

    //------------------------------------ Lage en observasjon ------------------------------------
    public Object createAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second, String pictureUrl, String planetNavn, String comments) {
        Observation currentList = getInfo(stedId);

        if(currentList.getName().equals(stedId)) {
            Observation added = new Observation(name, animal, sted, antall, day, mnd, year, hour, minute, second, pictureUrl,planetNavn,comments);
            obsListe.add(added);
        }
        File fil = skriveTilJson(filNavn, obsListe);
        return leseFraJson(fil.toString());
    }

    public Object updateAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments ) {
        List<Observation> obs = getAllInfo();

        for (Observation thisObs : obs){
            if (thisObs.getName().equals(stedId)) {
                thisObs.setName(name);
                thisObs.setAnimal(animal);
                thisObs.setSted(sted);
                thisObs.setAntall(antall);
                thisObs.setDay(day);
                thisObs.setMnd(mnd);
                thisObs.setYear(year);
                thisObs.setHour(hour);
                thisObs.setMinute(minute);
                thisObs.setSecond(second);
                thisObs.setPlanet(planetNavn);
                thisObs.setPictureUrl(pictureUrl);
                thisObs.setComments(comments);
            }
        }
        File fil = skriveTilJson(filNavn,obsListe);
        return leseFraJson(fil.toString());
    }


    public Object deleteAObservation(String stedId, String filNavn) {
        getAllInfo().remove(getInfo(stedId));
        File fil = skriveTilJson(filNavn, obsListe);
        return leseFraJson(fil.toString());
    }











}
