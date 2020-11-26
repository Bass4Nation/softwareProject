package no.find.parking;

import hiof.findParking.Repository.JsonRepository;
import hiof.findParking.model.Annonse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tester {


    @Test()
    public void createAnnonse() {
        String fylke = "Viken";
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "www.www.www";
        String expected = String.format("Annonsetittel %s, pris: %f kr/dag, beskrivelse: %s, addresse: %s ",tittel, pris,beskrivelse, adresse);

        JsonRepository repository = new JsonRepository();
        Object actual = repository.createAnnonse(fylke, adresse,sted,beskrivelse,tittel,pris,pictureUrl);
        System.out.println(actual);

        Assertions.assertEquals(expected,actual.toString());
    }

    @Test
    public void annonse() {
        String fylke = "Viken";
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "www.www.www";
        String expected = String.format("Annonsetittel %s, pris: %f kr/dag, beskrivelse: %s, addresse: %s ",tittel, pris,beskrivelse, adresse);

        Annonse actual = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrl);
        System.out.println(actual);

        Assertions.assertEquals(expected,actual.toString());
    }


}

