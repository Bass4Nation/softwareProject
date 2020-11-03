package hiof.findParking.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;
import hiof.findParking.model.Bruker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonRepository implements IRepository {
//    public List<Alle_Annonser> allAnnonser = fileReader("Annonser.json");
private List<Alle_Annonser> allAnnonser = new ArrayList<>();

    public JsonRepository() {
        mangeAnnonser();
        writeToFile("annonser.json", allAnnonser);
    }


    private void mangeAnnonser() {

        Alle_Annonser obsListe = new Alle_Annonser("Viken");
//------------------------------------------------------ Annonser ----------------------------
        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", 50, "https://mediadc.brightspotcdn.com/dims4/default/7911b12/2147483647/strip/true/crop/2290x1322+0+0/resize/2290x1322!/quality/90/?url=https%3A%2F%2Fmediadc.brightspotcdn.com%2F62%2F05%2Fbbcbb53c660de0e2576a8de0491d%2Fe023efc13eb249b7634a4046b6fe6800.jpg"));
        obsListe.addAnnonse(new Annonse(bruker1.getAdresse(),bruker1.getNavn(),"Dette er annonse 2 beskrivelse", "Billig plass i Halden", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));


        allAnnonser.add(obsListe);
        //--------------------------------- Observation -----------------------------------------------


    }


    public List<Alle_Annonser> fileReader(String fileGet) {
        List<Alle_Annonser> readAnnonser = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Alle_Annonser[] annonseArray = objectMapper.readValue(new File(fileGet), Alle_Annonser[].class);

            readAnnonser = Arrays.asList(annonseArray);
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(readAnnonser);
        return readAnnonser;
    }

    public static File writeToFile(String filename, List<Alle_Annonser> alle_annonser) {
        File file = new File(filename);
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, alle_annonser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    public List<Alle_Annonser> getAlleAnnonser() {
        return allAnnonser;
    }

    public Alle_Annonser getAnnonserFylke(String locName) {
        for (Alle_Annonser test : allAnnonser)
            if (test.getName().equals(locName)) {
                return test;
            }

        return null;
    }

    @Override
    public Alle_Annonser getAlleAnnonse(String AlleAnnonseName) {
        return null;
    }


    @Override
    public Annonse getAnnonse(String planetSystemName, String id) {
        return null;
    }

    @Override
    public ArrayList<Annonse> getAnnonser(String AlleAnnonseName) {
        return null;
    }


    public Object createAnnonse(String filename, String fylke,String adresse, String navn, String beskrivelse, String name, int pris, String pictureUrl) {
        Alle_Annonser currentLoc = getAnnonserFylke(fylke);

        if(currentLoc.getName().equals(fylke)) {
            Annonse aAnnonse = new Annonse(adresse, navn, beskrivelse, name, pris, pictureUrl);

            getAnnonserFylke(fylke).getAnnonser().add(aAnnonse);
        }

        File file = writeToFile(filename, allAnnonser);

        return fileReader(file.toString());
    }
}
