package hiof.findParking.model;


public class Annonse extends Info{
    private String tittel;
    private double pris;
    private String pictureUrl;
    private int id;
    private static int teller;
    private boolean status;
    private String statusInfo;


    public Annonse(String adresse, String sted, String beskrivelse, String tittel, double pris, String pictureUrl) {
        super(adresse, sted, beskrivelse);
        this.tittel = tittel;
        this.pris = pris;
        this.pictureUrl = pictureUrl;
        this.id = teller++;
    }

    public Annonse(){}

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getId() {
        return id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString(){
        return String.format("Annonsetittel %s, pris: %f kr/dag, beskrivelse: %s, addresse: %s ",tittel, pris,getBeskrivelse(), getAdresse());
    }

}
