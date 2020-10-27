package hiof.findParking.repository;

import hiof.findParking.model.Annonse;
import hiof.findParking.model.Bruker;

import java.util.ArrayList;

public class Repository implements IRepository {
//    Velger å bruke List siden den passer best til det jeg har kodet før. Og jeg kan mest om det
//    enn Map eller andre måter å lagre informasjon. Så det er derfor jeg bruker List

    //    public List<Observation> obsListe = new ArrayList<>(); // ------------- For å lage en JSON fil.
//    public List<Annonse> obsListe = leseFraJson("Annonser.json");
    private ArrayList<Annonse> annonser = new ArrayList<>();

    // -------- Har repository Under her for å lage Json filen -------------------------------
    public Repository() {

        //----------------------- Lager dyrene først så inn i observasjoner
//------------------------------------------------------ Annonser ----------------------------
        ArrayList<Annonse> obsListe = new ArrayList<>();
        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
        Annonse ano1 = new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", 50);
        Annonse ano2 = new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dette er annonse 2", "Billig plass i Halden", 20);


        annonser.add(ano1);
        annonser.add(ano2);
        //--------------------------------- Observation -----------------------------------------------

//        obsListe.add(one);
//        obsListe.add(two);
//        obsListe.add(three);
//        obsListe.add(four);
//        obsListe.add(five);
//        obsListe.add(six);
//        obsListe.add(seven);

    }

    @Override
    public ArrayList<Annonse> getPlanetSystems() {
        return new ArrayList<>(annonser);
    }

//    public List<Annonse> getAllInfo() {
//
////        File file = skriveTilJson("ObsList.json", obsListe);
////        ---------- Tenker det er naturlig å sortere etter Id --- Så går det i en rekkefølge ------------
////      3.2  c) Legg til en naturlig sortering i et par av klassene du tror det kan være aktuelt å kunne sortere.
////       Her Så velger jeg å sortere etter Animal name. Bare for å vise at den sorterer alfabetisk.
//        obsListe.sort(Comparator.comparing(Annonse::getTittel));
//        return obsListe;
//    }
//
//    //    ---------- Hentet fra oblig 5 som jeg hadde -- Eneste lagt inn Observation ----
//    public static File skriveTilJson(String filnavn, List< Annonse > liste) {
//        File fil = new File(filnavn);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fil, liste);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return fil;
//    }
//
//    public List<Annonse> leseFraJson(String filnavn) {
//        List<Annonse> lesteObsJson = new ArrayList<>();
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Annonse[] obsArray = objectMapper.readValue(new File(filnavn), Annonse[].class);
//            lesteObsJson = Arrays.asList(obsArray);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lesteObsJson;
//    }
//
//    public Annonse getInfo(String stedId) {
//
//        for (Annonse observation : obsListe) {
//            if (observation.getNavn().equals(stedId))
//                return observation;
//        }
//        return null;
//    }
//
////    Får ikke testet CRUD, siden jeg har bare en vue side. Så har prøvd å tilpasse de som virket i oblig 5 (min versjon) til denne oppgaven.
//
////    //------------------------------------ Lage en observasjon ------------------------------------
////    public Object createAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second, String pictureUrl, String planetNavn, String comments) {
////        Observation currentList = getInfo(stedId);
////
////        if(currentList.getName().equals(stedId)) {
////            Observation added = new Observation(name, animal, sted, antall, day, mnd, year, hour, minute, second, pictureUrl,planetNavn,comments);
////            obsListe.add(added);
////        }
////        File fil = skriveTilJson(filNavn, obsListe);
////        return leseFraJson(fil.toString());
////    }
////
////    public Object updateAObservation(String filNavn, String stedId, String name, Animal animal, Location sted, int antall, int day, int mnd, int year, int hour, int minute, int second , String pictureUrl, String planetNavn, String comments ) {
////        List<Observation> obs = getAllInfo();
////
////        for (Observation thisObs : obs){
////            if (thisObs.getName().equals(stedId)) {
////                thisObs.setName(name);
////                thisObs.setAnimal(animal);
////                thisObs.setSted(sted);
////                thisObs.setAntall(antall);
////                thisObs.setDay(day);
////                thisObs.setMnd(mnd);
////                thisObs.setYear(year);
////                thisObs.setHour(hour);
////                thisObs.setMinute(minute);
////                thisObs.setSecond(second);
////                thisObs.setPlanet(planetNavn);
////                thisObs.setPictureUrl(pictureUrl);
////                thisObs.setComments(comments);
////            }
////        }
////        File fil = skriveTilJson(filNavn,obsListe);
////        return leseFraJson(fil.toString());
////    }
////
////
////    public Object deleteAObservation(String stedId, String filNavn) {
////        getAllInfo().remove(getInfo(stedId));
////        File fil = skriveTilJson(filNavn, obsListe);
////        return leseFraJson(fil.toString());
////    }
////
////
////
//
//
//





}
