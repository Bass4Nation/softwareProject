package hiof.findParking.model;

public class Annonse extends Info{
    private String tittel, kommentarer;
    private int antallPlasser;

    public Annonse(String tittel, String kommentarer, int antallPlasser) {
        this.tittel = tittel;
        this.kommentarer = kommentarer;
        this.antallPlasser = antallPlasser;
    }

    public Annonse(String beskrivelse, String tittel, String kommentarer, int antallPlasser) {
        super(beskrivelse);
        this.tittel = tittel;
        this.kommentarer = kommentarer;
        this.antallPlasser = antallPlasser;
    }

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
}
