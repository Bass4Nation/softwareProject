package hiof.findParking.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Alle_Annonser {
    private String fylke, pictureUrl;
    private List<Annonse> annonser = new ArrayList<Annonse>();

    public Alle_Annonser(String fylke) {
        this.fylke = fylke;
    }

    public Alle_Annonser(String fylke, String pictureUrl) {
        this.fylke = fylke;
        this.pictureUrl = pictureUrl;
    }

    public Alle_Annonser() {
    }


    public void addAnnonse(Annonse annonse) {
        annonser.add(annonse);
    }

    public String getName() {
        return fylke;
    }

    public List<Annonse> getAnnonser() {
        return annonser;
    }

    public void setAnnonser(List<Annonse> annonser) {
        this.annonser = annonser;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setName(String name) {
        this.fylke = name;
    }

    @Override
    public String toString() {
        return String.format("Det er %d annonser på denne siden", annonser.size());
    }

}
