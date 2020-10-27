package hiof.findParking.model;

public class ParkPlass {
    private String utleier;
    private int pris;
    private boolean status;

    public ParkPlass(int pris) {
        this.pris = pris;
    }

    public ParkPlass(String utleier, int pris, boolean status) {
        this.utleier = utleier;
        this.pris = pris;
        this.status = status;
    }

    public String getUtleier() {
        return utleier;
    }

    public void setUtleier(String utleier) {
        this.utleier = utleier;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String erPlassenLedig(){
        String answers = "";
        if(status){
            answers = "ledig";
        } else {
            answers = "utleid";
        }
        return answers;
    }

    @Override
    public String toString(){
        return String.format("Plassen koster %d i timen og navn på utleier er %s og denne plassen er %s. ",pris, utleier, erPlassenLedig());
    }
}
