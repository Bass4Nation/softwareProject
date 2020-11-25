package hiof.findParking.Controller;

import hiof.findParking.model.Annonse;
import hiof.findParking.Repository.IRepository;
import io.javalin.http.Context;

import java.util.List;

public class AnnonseController {
    private IRepository repository;

    public AnnonseController(IRepository repository) {
        this.repository = repository;
    }

    public void getAnnonser(Context context) {
        String planetSystemName = context.pathParam("alle-annonser-id");
        List<Annonse> planets = repository.getAnnonser(planetSystemName);

        context.json(planets);
    }

    public void getAnnonse(Context context) {
        String planetSystemName = context.pathParam("alle-annonser-id");
        String planetName = context.pathParam("annonse-id");

        context.json(repository.getAnnonse(planetSystemName, planetName));
    }

}
