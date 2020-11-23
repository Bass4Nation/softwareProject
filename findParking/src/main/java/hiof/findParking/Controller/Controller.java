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

    public void getAnnonser(Context context) {
        String fylke = context.pathParam("alle-annonser-id");
        context.json(repository.getAnnonserFylke(fylke));
    }




}
