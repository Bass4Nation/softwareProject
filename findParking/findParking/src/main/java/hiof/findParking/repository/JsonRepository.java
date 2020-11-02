package hiof.findParking.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hiof.findParking.model.Alle_Annonser;
import hiof.findParking.model.Annonse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonRepository implements IRepository {
    public List<Alle_Annonser> allAnnonser = fileReader("Annonser.json");


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


    public Object createAnnonse(String filename, String adresse, String navn, String beskrivelse, String name, int pris, String pictureUrl) {

            Annonse freshAnnonse = new Annonse(adresse, navn, beskrivelse, name, pris, pictureUrl);
//Tror noe må tukles med for at den skal akseptere en annen verdi
            getAlleAnnonser().add(freshAnnonse);


        File file = writeToFile(filename, allAnnonser);

        return fileReader(file.toString());
    }
}
