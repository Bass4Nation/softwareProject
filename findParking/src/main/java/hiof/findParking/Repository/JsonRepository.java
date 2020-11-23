package hiof.findParking.Repository;

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
    public List<Alle_Annonser> allAnnonser = fileReader("Annonser.json");
//private List<Alle_Annonser> allAnnonser = new ArrayList<>();

//    public JsonRepository() {
//        mangeAnnonser();
//        writeToFile("Annonser.json", allAnnonser);
//    }


    private void mangeAnnonser() {

        Alle_Annonser viken = new Alle_Annonser("Viken","https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/viken.jpg");
        Alle_Annonser oslo = new Alle_Annonser("Oslo","https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/oslo.jpg");
//------------------------------------------------------ Bruker ----------------------------
        Bruker bruker1 = new Bruker("norman@nisse.no", "Adresse 12B", "10259654", "Ola Nordman");
        Bruker bruker2 = new Bruker("ola@nisse.no", "Adresse 10C", "99998877", "Nisse Ola");
//------------------------------------------------------ Annonser ----------------------------
        viken.addAnnonse(new Annonse("Mosseporten 20","Moss",bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Halden", 50, "https://mediadc.brightspotcdn.com/dims4/default/7911b12/2147483647/strip/true/crop/2290x1322+0+0/resize/2290x1322!/quality/90/?url=https%3A%2F%2Fmediadc.brightspotcdn.com%2F62%2F05%2Fbbcbb53c660de0e2576a8de0491d%2Fe023efc13eb249b7634a4046b6fe6800.jpg"));
        viken.addAnnonse(new Annonse("Sarpeveien 19","Sarpsborg",bruker1.getNavn(),"Dette er annonse 2 beskrivelse", "Billig plass i Halden", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));
        viken.addAnnonse(new Annonse("Haldenveien 1374","Rakkestad",bruker2.getNavn(),"Dette er annonse 1 i Oslo", "Billig plass i Halden", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));
        viken.addAnnonse(new Annonse("Solveien 12C", "Halden", bruker1.getNavn(), "TASIDGHIUASDHIAUOSHDIOUAS", "En annen plass i Halden", 10, "https://cdn.abcotvs.com/dip/images/5896174_013120-kgo-parking-spot-img_Image_00-00-59,06.jpg?w=1600" ));

        oslo.addAnnonse(new Annonse("Kongsgate 10","Oslo",bruker2.getNavn(),"Dette er annonse 1 i Oslo", "Billig plass i Halden", 200, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));


        allAnnonser.add(viken);
        allAnnonser.add(oslo);
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

    @Override
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
    public Annonse getAnnonse(String AlleAnnonseName, String annonseId) {
        int id = Integer.parseInt(annonseId);
        for (Annonse annonse : getAnnonser(AlleAnnonseName)){
//            Må endre her om den skal sjekke etter noe annet på en singel annonse
            if ((annonse.getId() == id)){
                return annonse;
            }
        }
        return null;
    }

    @Override
    public List<Annonse> getAnnonser(String planetSystemName) {
        return getAnnonserFylke(planetSystemName).getAnnonser();
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
