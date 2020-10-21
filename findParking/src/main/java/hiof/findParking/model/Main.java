package hiof.findParking.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    Laget for å teste hele prosjektet pluss nettsiden.


    public static void main(String[] args) {
        System.out.println("Dette er main i model");
//        List<Observation> obsListe = new ArrayList<>();





//        leseListe(obsListe);


    }

    public static void leseListe(List list){
        for(int i = 0; i < list.size(); i++){
            System.out.println("---------------------------------------------------------------");
            System.out.println(list.get(i));
        }
    }

}
