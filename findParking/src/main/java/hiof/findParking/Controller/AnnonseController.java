package hiof.findParking.Controller;

import hiof.findParking.model.Annonse;
import hiof.findParking.repository.IRepository;
import io.javalin.http.Context;

import java.util.ArrayList;

public class AnnonseController {
    private IRepository repository;

    public AnnonseController(IRepository repository) {
        this.repository = repository;
    }

    public void getAnnonser(Context context) {
        String planetSystemName = context.pathParam("alle-annonser-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Annonse> planets = repository.getAnnonser(planetSystemName);

//        if (sortBy != null) {
//            switch (sortBy) {
//                case "name":
//                    Collections.sort(planets);
//                    break;
//                case "mass":
//                    planets.sort((o1, o2) -> (int) (o1.getMass() - o2.getMass()));
//                    break;
//                case "radius":
//                    planets.sort((o1, o2) -> {
//                        if (o1.getRadius() < o2.getRadius())
//                            return -1;
//                        else if(o1.getRadius() > o2.getRadius())
//                            return 1;
//                        return 0;
//                    });
//                    break;
//            }
//        }
//  SORT

        context.json(planets);
    }

    public void getAnnonse(Context context) {
        String planetSystemName = context.pathParam("alle-annonser-id");
        String planetName = context.pathParam("annonse-id");

        context.json(repository.getAnnonse(planetSystemName, planetName));
    }

}
