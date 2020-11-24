package hiof.findParking.model;

public abstract class Info extends Bruker {
    private String beskrivelse;

    public Info(String adresse, String navn, String beskrivelse) {
        super(adresse, navn);
        this.beskrivelse = beskrivelse;
    }

    public Info(String adresse, String sted, String navn, String beskrivelse) {
        super(adresse, sted, navn);
        this.beskrivelse = beskrivelse;
    }

    public Info(){}


    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
