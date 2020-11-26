package hiof.findParking.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Bruker extends KontaktInfo {
//    private noe for annonser
    private String navn, passord;
    private int[] annonserId;
    private List<Annonse> annonser = new ArrayList<Annonse>();


    public Bruker(String epost, String adresse, String telefonnummer, String navn) {
        super(epost, adresse, telefonnummer);
        this.navn = navn;
    }
    public Bruker(String epost,String passord, String navn, String adresse, String telefonnummer, int[] annonserId, List<Annonse> annonser) {
        super(epost, adresse, telefonnummer);
        this.navn = navn;
        this.passord = passord;
        this.annonserId = annonserId;
        this.annonser = annonser;
    }

    public Bruker(){}

    public int[] getAnnonserId() {
        return annonserId;
    }

    public void setAnnonserId(int[] annonserId) {
        this.annonserId = annonserId;
    }

    public void addAnnonse(Annonse annonse) {
        for (var i = 0; i < annonserId.length; i++){
            int j =  annonserId[i];
            if(annonse.getId() == j){
//                System.out.println(annonse);
                annonser.add(annonse);
            }
        }
    }


    public List<Annonse> getAnnonser() {
        return annonser;
    }

    public void setAnnonser(List<Annonse> annonser) {
        this.annonser = annonser;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return String.format("Denne brukeren heter %s og har %d annonser på denne siden\n",navn, annonser.size());
    }


}
