package hiof.findParking.model;

public abstract class Lokasjon {
    private String Addresse;
    private int cord; // Kan hende det er bedre å bytte til x og y.

    public Lokasjon(String addresse, int cord) {
        Addresse = addresse;
        this.cord = cord;
    }

    public Lokasjon(String addresse) {
        Addresse = addresse;
    }

    public Lokasjon(int cord) {
        this.cord = cord;
    }

    public Lokasjon(){}

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String addresse) {
        Addresse = addresse;
    }

    public int getCord() {
        return cord;
    }

    public void setCord(int cord) {
        this.cord = cord;
    }
}
