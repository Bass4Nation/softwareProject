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
        String alleAnnonserId = context.pathParam("alle-annonser-id");
        List<Annonse> annonser = repository.getAnnonser(alleAnnonserId);

        context.json(annonser);
    }

    public void getAnnonse(Context context) {
        String alleAnnonserId = context.pathParam("alle-annonser-id");
        String annonserId = context.pathParam("annonse-id");

        context.json(repository.getAnnonse(alleAnnonserId, annonserId));
    }

}
