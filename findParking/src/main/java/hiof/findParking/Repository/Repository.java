package hiof.findParking.repository;

import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;
import hiof.findParking.model.Bruker;

import java.util.ArrayList;

public class Repository implements IRepository {
//    Velger å bruke List siden den passer best til det jeg har kodet før. Og jeg kan mest om det
//    enn Map eller andre måter å lagre informasjon. Så det er derfor jeg bruker List

    //    public List<Observation> obsListe = new ArrayList<>(); // ------------- For å lage en JSON fil.
//    public List<Annonse> obsListe = leseFraJson("Annonser.json");
    private ArrayList<Alle_Annonser> annonser = new ArrayList<>();

    // -------- Har repository Under her for å lage Json filen -------------------------------
    public Repository() {
        mangeAnnonser();
    }
    private void mangeAnnonser() {

        Alle_Annonser obsListe = new Alle_Annonser("Alle Annonser");
//------------------------------------------------------ Annonser ----------------------------
        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", 50, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSWXwdOz6OapoLyHg8lCBtdcgaa0ABsBSbLMg&usqp=CAU"));
        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dette er annonse 2", "Billig plass i Halden", 20, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSWXwdOz6OapoLyHg8lCBtdcgaa0ABsBSbLMg&usqp=CAU"));


        annonser.add(obsListe);
        //--------------------------------- Observation -----------------------------------------------


    }

    @Override
    public ArrayList<Alle_Annonser> getAlleAnnonser() {
        return new ArrayList<>(annonser);
    }

    @Override
    public Alle_Annonser getAlleAnnonse(String AlleAnnonseName) {
        for (Alle_Annonser alle_annonser : annonser) {
            if (alle_annonser.getName().equals(AlleAnnonseName)) {
                return alle_annonser;
            }
        }
        return null;
    }
}
