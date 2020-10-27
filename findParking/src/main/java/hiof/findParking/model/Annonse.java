package hiof.findParking.model;

public class Annonse extends Info{
    private String tittel, kommentarer;
    private int antallPlasser;
    private int pris;
    private int id;
    private static int teller;


//    public Annonse(String tittel, String kommentarer, int antallPlasser) {
//        this.tittel = tittel;
//        this.kommentarer = kommentarer;
//        this.antallPlasser = antallPlasser;
//    }



//    public Annonse(String beskrivelse, String tittel, String kommentarer, int antallPlasser) {
//        super(beskrivelse);
//        this.tittel = tittel;
//        this.kommentarer = kommentarer;
//        this.antallPlasser = antallPlasser;
//    }

    public Annonse(String adresse, String navn, String beskrivelse, String tittel, int pris) {
        super(adresse, navn, beskrivelse);
        this.tittel = tittel;
        this.pris = pris;
        this.id = teller++;
    }
//    public Annonse(){}

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
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

    @Override
    public String toString(){
        return String.format("Annonsetittel %s, pris: %d kr/t, beskrivelse: %s, eier: %s, addresse: %s ",tittel, pris,getBeskrivelse(), getNavn(), getAdresse());
    }

}
