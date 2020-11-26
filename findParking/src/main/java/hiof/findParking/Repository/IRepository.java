package hiof.findParking.Repository;
import hiof.findParking.model.*;
import java.util.List;

public interface IRepository {

    List<Alle_Annonser> getAlleAnnonser();
    List<Bruker> getAlleBrukere();
    Bruker getEnBrukere(String navn);
    List<Annonse> getBrukerAnnonser(String navn);
    List<Annonse>  getAlleAnnonse(String AlleAnnonseName);
    Alle_Annonser getAnnonserFylke(String AlleAnnonseName);
    Annonse getAnnonse(String AlleAnnonseName, String id);
    List<Annonse> getAnnonser(String AlleAnnonseName);
    Object createAnnonse(String fylke,String adresse, String sted, String beskrivelse, String tittel, double pris, String pictureUrl);

}