package hiof.findParking.model;

import java.util.Comparator;

public class Annonse extends Info{
    private String name, kommentarer;
    private int antallPlasser;
    private int pris;
    private String pictureUrl;
    private int id;
    private static int teller;
    private boolean status;
    private String statusInfo;


    public Annonse(String adresse, String navn, String beskrivelse, String name, int pris, String pictureUrl) {
        super(adresse, navn, beskrivelse);
        this.name = name;
        this.pris = pris;
        this.pictureUrl = pictureUrl;
        this.id = teller++;
    }

    public Annonse(String adresse, String navn, String beskrivelse, String tittel, String pictureUrl) {
        super(adresse, navn, beskrivelse);
        this.name = tittel;
        this.pictureUrl = pictureUrl;
        this.id = teller++;
    }

    public Annonse(String adresse, String sted, String navn, String beskrivelse, String name, int pris, String pictureUrl) {
        super(adresse, sted, navn, beskrivelse);
        this.name = name;
        this.pris = pris;
        this.pictureUrl = pictureUrl;
        this.id = teller++;
    }

    public Annonse(){}

    public static Comparator<Annonse> alphabetical = new Comparator<Annonse>(){
        @Override
        public int compare(Annonse oneAnnonse, Annonse twoAnnonse){
            return (oneAnnonse.getNavn().compareTo(twoAnnonse.getNavn()));
        }
    };


    public String getStatusInfo(boolean status) {
        status = true;
        if(status){
            System.out.println("Denne plassen er ledig");
            statusInfo = "Ledig";
        }else{
            System.out.println("Denne plassen er ikke ledig");
            statusInfo = "Utleid";
        }
        return statusInfo;
    }

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
        return name;
    }

    public void setTittel(String tittel) {
        this.name = tittel;
    }

    public String getKommentarer() {
        return kommentarer;
    }

    public void setKommentarer(String kommentarer) {
        this.kommentarer = kommentarer;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString(){
        return String.format("Annonsetittel %s, pris: %d kr/t, beskrivelse: %s, eier: %s, addresse: %s ",name, pris,getBeskrivelse(), getNavn(), getAdresse());
    }

}
