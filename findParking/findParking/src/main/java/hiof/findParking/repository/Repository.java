//package hiof.findParking.repository;
//
//import hiof.findParking.model.Alle_Annonser;
//import hiof.findParking.model.Annonse;
//import hiof.findParking.model.Bruker;
//
//import java.util.ArrayList;
//
//public class Repository implements IRepository {
////    Velger å bruke List siden den passer best til det jeg har kodet før. Og jeg kan mest om det
////    enn Map eller andre måter å lagre informasjon. Så det er derfor jeg bruker List
//
//    //    public List<Observation> obsListe = new ArrayList<>(); // ------------- For å lage en JSON fil.
////    public List<Annonse> obsListe = leseFraJson("Annonser.json");
//    private ArrayList<Alle_Annonser> annonser = new ArrayList<>();
//
//    // -------- Har repository Under her for å lage Json filen -------------------------------
//    public Repository() {
//        mangeAnnonser();
//    }
//    private void mangeAnnonser() {
//
//        Alle_Annonser obsListe = new Alle_Annonser("Alle Annonser");
////------------------------------------------------------ Annonser ----------------------------
//        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
//        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", 50, "https://mediadc.brightspotcdn.com/dims4/default/7911b12/2147483647/strip/true/crop/2290x1322+0+0/resize/2290x1322!/quality/90/?url=https%3A%2F%2Fmediadc.brightspotcdn.com%2F62%2F05%2Fbbcbb53c660de0e2576a8de0491d%2Fe023efc13eb249b7634a4046b6fe6800.jpg"));
//        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dette er annonse 2 beskrivelse", "Billig plass i Halden", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));
//
//
//        annonser.add(obsListe);
//        //--------------------------------- Observation -----------------------------------------------
//
//
//    }
//
//    @Override
//    public ArrayList<Alle_Annonser> getAlleAnnonser() {
//        return new ArrayList<>(annonser);
//    }
//
//    @Override
//    public Alle_Annonser getAlleAnnonse(String AlleAnnonseName) {
//        for (Alle_Annonser alle_annonser : annonser) {
//            if (alle_annonser.getName().equals(AlleAnnonseName)) {
//                return alle_annonser;
//            }
//        }
//        return null;
//    }
//
//
//    @Override
//    public Annonse getAnnonse(String planetSystemName, String planetName) {
//        return getAlleAnnonse(planetSystemName).getAnnonse(planetName);
//    }
//
//    @Override
//    public ArrayList<Annonse> getAnnonser(String planetSystemName) {
//        return getAlleAnnonse(planetSystemName).getAnnonser();
//    }
//
//}
