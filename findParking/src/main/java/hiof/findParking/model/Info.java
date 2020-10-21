package hiof.findParking.model;

public abstract class Info {
    private String beskrivelse;

    public Info(String beskrivelse) {
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
