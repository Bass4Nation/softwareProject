package no.find.parking;

import hiof.findParking.Repository.JsonRepository;
import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;
import hiof.findParking.model.Bruker;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

public class Tester_ToString_Og_Create_Annonse_Metoden {

    @Test
    public void tester_Annonse_ToString() {

        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "www.www.www";
        String expected = String.format("Annonsetittel %s, pris: %f kr/dag, beskrivelse: %s, addresse: %s ",tittel, pris,beskrivelse, adresse);

        Annonse actual = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrl);

        Assertions.assertEquals(expected,actual.toString(),"Det er noe feil med 'actual' annonse");
    }
    @Test
    public void tester_Annonse_ToString_Om_Ikke_Lik() {

        String adresse = "BRAVeien";
        String adresse2 = "BRAVeien 6C";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "www.www.www";
        String unexpected = String.format("Annonsetittel %s, pris: %f kr/dag, beskrivelse: %s, addresse: %s ",tittel, pris,beskrivelse, adresse);

        Annonse actual = new Annonse(adresse2,sted,beskrivelse,tittel,pris,pictureUrl);

        Assertions.assertNotEquals(unexpected,actual.toString(),"'actual' Annonse er lik som 'expected' ");
    }

    @Test
    public void tester_Alle_Annonser_ToString() {
        String fylke = "Viken";
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "FylkeBilde";
        String pictureUrlAnnonse = "AnnonseBilde";

        Alle_Annonser actual = new Alle_Annonser(fylke,pictureUrl);
        Annonse annonse = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrlAnnonse);
        actual.addAnnonse(annonse);
        String expected = String.format("Det er %d annonser i %s med bildet : %s", actual.getAnnonser().size(), fylke, pictureUrl);

        System.out.println(actual);

        Assertions.assertEquals(expected,actual.toString(),"Det er noe feil med 'actual' Alle_Annonser");
    }
    @Test
    public void tester_Alle_Annonser_ToString_Om_Ikke_Lik() {
        String fylke = "Viken";
        String fylke2 = "Oslo";
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrl = "FylkeBilde";
        String pictureUrlAnnonse = "AnnonseBilde";

        Alle_Annonser actual = new Alle_Annonser(fylke,pictureUrl);
        Annonse annonse = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrlAnnonse);
        actual.addAnnonse(annonse);
        String unexpected = String.format("Det er %d annonser i %s med bildet : %s", actual.getAnnonser().size(), fylke2, pictureUrl);

        Assertions.assertNotEquals(unexpected,actual.toString(),"'actual' Alle_Annonser er lik som 'expected'");
    }
    @Test
    public void tester_Bruker_ToString() {
//      ----------Bruker----------
        String epost = "Epost";
        String passord = "Passord";
        String navn = "Ola Nordman";
        String adresseBruker = "veien 6C";
        String telefonnummer = "12356479";
        int[] annonserId = {1, 2};
        List<Annonse> annonser = new ArrayList<>();

//        -------Annonse---------
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrlAnnonse = "AnnonseBilde";

        Annonse annonse = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrlAnnonse);
        annonser.add(annonse);

        Bruker actual = new Bruker(epost, passord, navn, adresseBruker, telefonnummer, annonserId, annonser);
        String expected = String.format("Denne brukeren heter %s og har %d annonser på denne siden med epost : %s\n",navn, actual.getAnnonser().size(), actual.getEpost());

        System.out.println(actual);

        Assertions.assertEquals(expected,actual.toString(),"Det er noe feil med 'actual' Bruker");
    }
    @Test
    public void tester_Bruker_ToString_Om_Ikke_Lik() {
//      ----------Bruker----------
        String epost = "Epost";
        String passord = "Passord";
        String navn = "Ola Nordman";
        String navn2 = "Francis Someone";
        String adresseBruker = "veien 6C";
        String telefonnummer = "12356479";
        int[] annonserId = {1, 2};
        List<Annonse> annonser = new ArrayList<>();

//        -------Annonse---------
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrlAnnonse = "AnnonseBilde";

        Annonse annonse = new Annonse(adresse,sted,beskrivelse,tittel,pris,pictureUrlAnnonse);
        annonser.add(annonse);

        Bruker actual = new Bruker(epost, passord, navn, adresseBruker, telefonnummer, annonserId, annonser);
        String unexpected = String.format("Denne brukeren heter %s og har %d annonser på denne siden med epost : %s\n",navn2, actual.getAnnonser().size(), actual.getEpost());

        System.out.println(actual);

        Assertions.assertNotEquals(unexpected,actual.toString(),"'actual' Bruker er lik som 'expected'");
    }


    @Test
    public void tester_creater_metoden_i_JsonRepository(){
//        Når denne blir kjørt så blir det også pushet til nettsiden/ skriver om Annonser.json filen
        String fylke = "Viken";
        String adresse = "BRAVeien";
        String sted = "Halden";
        String beskrivelse = "beskrivelse";
        String tittel = "Annonse";
        double pris = 10;
        String pictureUrlAnnonse = "AnnonseBilde";

        JsonRepository repository = new JsonRepository();
        Object creator = repository.createAnnonse(fylke,adresse,sted,beskrivelse,tittel,pris,pictureUrlAnnonse);

        Assertions.assertNotNull(creator,"Annonsen som blir laget er tom");
    }



}

