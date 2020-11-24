package hiof.findParking.model;

public abstract class KontaktInfo {
    private String Epost, Adresse, telefonnummer, Sted;

    public KontaktInfo(String epost, String adresse, String telefonnummer) {
        Epost = epost;
        Adresse = adresse;
        this.telefonnummer = telefonnummer;
    }

    public KontaktInfo( String adresse, String sted) {
        Adresse = adresse;
        Sted = sted;
    }

    public String getSted() {
        return Sted;
    }

    public void setSted(String sted) {
        Sted = sted;
    }

    public KontaktInfo(String adresse) {
        Adresse = adresse;
    }

    public KontaktInfo(){}

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
