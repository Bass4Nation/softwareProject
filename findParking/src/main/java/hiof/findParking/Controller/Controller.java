package hiof.findParking.Controller;


import io.javalin.http.Context;
import hiof.findParking.repository.IRepository;


public class Controller {
    private IRepository repository;


    public Controller(IRepository repository) {
        this.repository = repository;
    }



    public void alleAnnonser(Context context){
        context.json(repository.getAllInfo());
    }

    public void annonse(Context context){
        String stedId = context.pathParam(":sted-id");
        context.json(repository.getInfo(stedId));


    }


}
