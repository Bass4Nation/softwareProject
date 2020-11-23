package hiof.findParking.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Alle_Annonser implements Comparable<Alle_Annonser>{
    private String name, pictureUrl;
    private List<Annonse> annonser = new ArrayList<Annonse>();

    public Alle_Annonser(String name) {
        this.name = name;
    }

    public Alle_Annonser(String name, String pictureUrl) {
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public Alle_Annonser(){}

    public void addAnnonse(Annonse annonse) {
        annonser.add(annonse);
    }

    public String getName() {
        return name;
    }

    public List<Annonse> getAnnonser() {
        return new ArrayList<Annonse>(annonser);
    }

    public Annonse getAnnonse(String tittel) {
        for (Annonse annonse : annonser) {
            if (annonse.getTittel().equals(tittel))
                return annonse;
        }
        return null;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Det er %d annonser på denne siden", annonser.size());
    }

    @Override
    public int compareTo(@NotNull Alle_Annonser o) {
        return 0;
    }
}
