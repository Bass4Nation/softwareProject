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
import java.util.Collections;
import java.util.List;

public class JsonRepository implements IRepository {
    public List<Alle_Annonser> allAnnonser = fileReader("Annonser.json");
    public List<Bruker> allBrukere = fileReaderUser("Brukere.json");
//private List<Alle_Annonser> allAnnonser = new ArrayList<>();
//private List<Bruker> allBrukere = new ArrayList<>();

//    public JsonRepository() {
//        mangeAnnonser();
//        writeToFile("Annonser.json", allAnnonser);
//        writeToFileUser("Brukere.json", allBrukere);
//    }


    private void mangeAnnonser() {

        Alle_Annonser viken = new Alle_Annonser("Viken","https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/viken.jpg");
        Alle_Annonser oslo = new Alle_Annonser("Oslo","https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/oslo.jpg");
        int[] id ={0,2,4};
        int[] emptyId ={1,3};
        List<Annonse> annonser = new ArrayList<>();
//------------------------------------------------------ Bruker ----------------------------
        Bruker bruker1 = new Bruker("find@parking.no","findparking", "Ola Nordman", "Adresse 12B", "123456789", id, annonser);
        Bruker bruker2 = new Bruker("admin", "admin","Admin", "Adresse 10C", "99998877", emptyId, annonser);
//-------------------------------------------------------- Annonser ----------------------------
        viken.addAnnonse(new Annonse("Mosseporten 20","Moss",bruker1.getNavn(),"Dorime noe rart beskrivelse", "En fin plass i Moss", 50, "https://mediadc.brightspotcdn.com/dims4/default/7911b12/2147483647/strip/true/crop/2290x1322+0+0/resize/2290x1322!/quality/90/?url=https%3A%2F%2Fmediadc.brightspotcdn.com%2F62%2F05%2Fbbcbb53c660de0e2576a8de0491d%2Fe023efc13eb249b7634a4046b6fe6800.jpg"));
        viken.addAnnonse(new Annonse("Sarpeveien 19","Sarpsborg",bruker1.getNavn(),"Dette er annonse 2 beskrivelse", "Billig plass i Sarpsborg", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));
        viken.addAnnonse(new Annonse("Haldenveien 1374","Rakkestad",bruker2.getNavn(),"Dette er annonse 1 i Oslo", "Billig plass i Rakkestad", 20, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));
        viken.addAnnonse(new Annonse("Solveien 12C", "Halden", bruker1.getNavn(), "TASIDGHIUASDHIAUOSHDIOUAS", "En annen plass i Halden", 10, "https://cdn.abcotvs.com/dip/images/5896174_013120-kgo-parking-spot-img_Image_00-00-59,06.jpg?w=1600" ));

        oslo.addAnnonse(new Annonse("Kongsgate 10","Oslo",bruker2.getNavn(),"Dette er annonse 1 i Oslo", "Billig plass i Oslo", 200, "https://www.goturpin.com/pages/news-and-announcements/image/section-image/parking-8.jpg"));


        allAnnonser.add(viken);
        allAnnonser.add(oslo);

        allBrukere.add(bruker1);
        allBrukere.add(bruker2);
        addAnnonserToUser(allBrukere, allAnnonser);


    }

    public List<Bruker> addAnnonserToUser(List<Bruker> user, List<Alle_Annonser> alleAnnonser){
        List<Annonse> annonseLister = new ArrayList<>();
        for (Alle_Annonser alle_annonser : alleAnnonser){
            annonseLister.addAll(alle_annonser.getAnnonser());
        }

        for(int j = 0; j < user.size(); j++){
            Bruker bruker = user.get(j);
            for(int i = 0; i < bruker.getAnnonserId().length; i++){
                System.out.println(bruker.getAnnonserId()[i]);
                for(int k = 0; k < annonseLister.size(); k++){
                   if (bruker.getAnnonserId()[i] == annonseLister.get(k).getId()){
                       bruker.addAnnonse(annonseLister.get(k));
                   }
                }
            }
        }


        System.out.println(user);
        return null;
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

    public List<Bruker> fileReaderUser(String fileGet) {
        List<Bruker> readAnnonser = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Bruker[] annonseArray = objectMapper.readValue(new File(fileGet), Bruker[].class);

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

    public static File writeToFileUser(String filename, List<Bruker> alle_annonser) {
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


    public List<Bruker> getAlleBrukere() {
        return allBrukere;
    }


@Override
    public Bruker getEnBrukere(String navn) {

        for (Bruker bruker : getAlleBrukere()){
//            Må endre her om den skal sjekke etter noe annet på en singel annonse
            if ((bruker.getNavn().equals(navn))){
                return bruker;
            }
        }
        return null;
    }
@Override
    public List<Annonse> getBrukerAnnonser(String navn) {
        return getEnBrukere(navn).getAnnonser();
    }



    @Override
    public Alle_Annonser getAnnonserFylke(String locName) {
        for (Alle_Annonser test : allAnnonser)
            if (test.getName().equals(locName)) {
                return test;
            }

        return null;
    }

//    @Override
//    public Alle_Annonser getAlleAnnonse(String AlleAnnonseName) {
//        return null;
//    }


    public List<Annonse> getAlleAnnonse(String AlleAnnonseName, String sortBy) {
        List<Annonse> annonser = getAnnonserFylke(AlleAnnonseName).getAnnonser();
//        public ArrayList<Planet> getAllPlanets(String systemName, String sortBy) {
//            ArrayList<Planet> planets = getAnnonser() getPlanetSystem(systemName).getPlanets();


        switch (sortBy) {


            case "name":
                Collections.sort(annonser, Annonse.alphabetical);
                break;
        }

        return getAnnonserFylke(AlleAnnonseName).getAnnonser();
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
    public List<Annonse> getAnnonser(String fylke) {
        return getAnnonserFylke(fylke).getAnnonser();
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
