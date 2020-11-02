package hiof.findParking.model;

public class Bruker extends KontaktInfo {
//    private noe for annonser
    private String navn;

    public Bruker(String epost, String adresse, String telefonnummer, String navn) {
        super(epost, adresse, telefonnummer);
        this.navn = navn;
    }

    public Bruker(String adresse, String navn) {
        super(adresse);
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
