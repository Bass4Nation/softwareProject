package hiof.findParking.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //Laget for å teste hele prosjektet pluss nettsiden.


    public static void main(String[] args) {
        System.out.println("Dette er main i model");
        ArrayList<Annonse> obsListe = new ArrayList<>();
        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
        Annonse ano1 = new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", null);
        Annonse ano2 = new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dette er annonse 2", "Billig plass i Halden", null);


        obsListe.add(ano1);
        obsListe.add(ano2);


        leseListe(obsListe);


    }

    public static void leseListe(List list){
        for(int i = 0; i < list.size(); i++){
            System.out.println("---------------------------------------------------------------");
            System.out.println(list.get(i));
        }
    }

}
