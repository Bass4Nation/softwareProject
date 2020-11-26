package hiof.findParking.model;

public abstract class Info extends KontaktInfo {
    private String beskrivelse;

    public Info(String adresse, String sted, String beskrivelse) {
        super(adresse, sted);
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
