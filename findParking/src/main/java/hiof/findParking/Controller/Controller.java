package hiof.findParking.Controller;


import io.javalin.http.Context;
import hiof.findParking.Repository.IRepository;

import java.util.Objects;


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

    public void createAnnonse(Context context){

        String fylke = context.formParam("fylke");
        String adresse = context.formParam("adresse");
        String sted = context.formParam("sted");
        String beskrivelse = context.formParam("beskrivelse");
        String tittel = context.formParam("tittel");
        double pris = Double.parseDouble(Objects.requireNonNull(context.formParam("pris")));
        String pictureUrl = context.formParam("pictureUrl");

        context.json(repository.createAnnonse(fylke, adresse, sted, beskrivelse,tittel,pris,pictureUrl));
        context.redirect(String.format("/find-parking/%s/", fylke));

    }
}
