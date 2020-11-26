package hiof.findParking.Controller;


import io.javalin.http.Context;
import hiof.findParking.Repository.IRepository;


public class Controller {
    private IRepository repository;


    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public void getAllAnnonser(Context context) {
        context.json(repository.getAlleAnnonser());
    }

    public void getAllBrukere(Context context) {
        context.json(repository.getAlleBrukere());
    }


    public void getEnBrukere(Context context) {
        String bruker = context.pathParam("bruker-id");
        context.json(repository.getEnBrukere(bruker));
    }
    public void getBrukerAnnonser(Context context) {
        String bruker = context.pathParam("bruker-id");
        context.json(repository.getBrukerAnnonser(bruker));
    }
    public void getAnnonser(Context context) {
        String fylke = context.pathParam("alle-annonser-id");
        context.json(repository.getAnnonserFylke(fylke));
    }

//    public void createAnnonse(Context context){
//
//
//
//        String fylkeId = context.pathParam(":alle-annonser-id");
//
//        String fylke = context.formParam("fylke");
//        String adresse = context.formParam("adresse");
//        String sted = context.formParam("sted");
//        String beskrivelse = context.formParam("beskrivelse");
//        String tittel = context.formParam("tittel");
////        int pris =  Integer.parseInt(Objects.requireNonNull(context.formParam("pris")));
//        double pris = 10;
//        String pictureUrl = context.formParam("pictureUrl");
//        System.out.println(fylke);
//        System.out.println(adresse);
//        System.out.println(pris);
//
//        context.json(repository.createAnnonse(fylke, adresse, sted, beskrivelse,tittel,pris,pictureUrl));
//        context.redirect(String.format("/find-parking/%s/", fylkeId));
//
//    }


    public void createAnnonse(Context context){



        String fylkeId = context.pathParam(":alle-annonser-id");

        String fylke = "Oslo";
        String adresse = "Veien 6c";
        String sted = "Oslo";
        String beskrivelse = "Dette er en beskrivelse";
        String tittel = "Dette er en annonse";
        double pris = 10;
        String pictureUrl = "https://www.canon.no/media/CINC_Sample_EOS_7D_Mark_II_MX054_-_35mm_F4.5_ISO1600_1_3985s_tcm85-1436734.jpg";
        System.out.println(fylke);
        System.out.println(adresse);
        System.out.println(pris);

        context.json(repository.createAnnonse(fylke, adresse, sted, beskrivelse,tittel,pris,pictureUrl));
        context.redirect(String.format("/find-parking/%s/", fylkeId));

    }



}
