package hiof.findParking.controller;


import io.javalin.http.Context;
import hiof.findParking.repository.IRepository;


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





//    public void alleAnnonser(Context context){
//        context.json(repository.getAllInfo());
//    }

//    public void annonse(Context context){
//        String stedId = context.pathParam(":sted-id");
//        context.json(repository.getInfo(stedId));
//
//
//    }


}
