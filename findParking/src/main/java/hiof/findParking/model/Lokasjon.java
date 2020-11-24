package hiof.findParking.model;

public abstract class Lokasjon {
    private String Addresse;
    private String Sted;
    private int cord; // Kan hende det er bedre å bytte til x og y.

    public Lokasjon(String addresse, int cord) {
        Addresse = addresse;
        this.cord = cord;
    }
    public Lokasjon(String addresse) {
        Addresse = addresse;
    }

    public Lokasjon(String addresse, String sted) {
        Addresse = addresse;
        Sted = sted;
    }

    public Lokasjon(int cord) {
        this.cord = cord;
    }

    public Lokasjon(){}

    public String getSted() {
        return Sted;
    }

    public void setSted(String sted) {
        Sted = sted;
    }

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
