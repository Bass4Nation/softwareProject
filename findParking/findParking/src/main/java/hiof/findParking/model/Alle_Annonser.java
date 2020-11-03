package hiof.findParking.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Alle_Annonser implements Comparable<Alle_Annonser>{
    private String name;
    private List<Annonse> annonser = new ArrayList<>();

    public Alle_Annonser(String name) {
        this.name = name;
    }

    public void addAnnonse(Annonse annonse) {
        annonser.add(annonse);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Annonse> getAnnonser() {
        return new ArrayList<Annonse>(annonser);
    }

    public Annonse getAnnonse(String tittel) {
        for (Annonse annonse : annonser) {
            if (annonse.getTittel().equals(tittel))
                return annonse;
        }
        return null;
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
