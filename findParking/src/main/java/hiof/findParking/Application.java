package hiof.findParking;

import hiof.findParking.Controller.*;
import hiof.findParking.Repository.*;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {
//    Laget for å teste hele prosjektet pluss nettsiden.

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7009);

        app.config.enableWebjars();

        // ----------------------------Views---------------------------
        app.before("/", ctx -> ctx.redirect("/find-parking"));

        app.get("/find-parking", new VueComponent("fylker"));
        app.get("/find-parking/minSide/:bruker-id", new VueComponent("bruker"));
        app.get("/find-parking/minSide/:bruker-id/annonser", new VueComponent("bruker-annonser"));
        app.get("/find-parking/:alle-annonser-id", new VueComponent("alle-annonsene"));
        app.get("/find-parking/:alle-annonser-id/annonser/:annonse-id", new VueComponent("annonse-detaljer"));




        IRepository repository = new JsonRepository();
        Controller controller = new Controller(repository);
        AnnonseController annonseController = new AnnonseController(repository);

        //-----------------------------API -------------------------------

        app.get("/api/find-parking", controller :: getAllAnnonser);
        app.get("/api/find-parking/login", controller::getAllBrukere);
        app.get("/api/find-parking/minSide/:bruker-id", controller::getEnBrukere);
        app.get("/api/find-parking/minSide/:bruker-id/annonser", controller::getBrukerAnnonser);
        app.get("/api/find-parking/:alle-annonser-id", controller::getAnnonser);

        app.get("/api/find-parking/:alle-annonser-id/annonser",annonseController ::getAnnonser);
        app.get("/api/find-parking/:alle-annonser-id/annonser/:annonse-id", annonseController ::getAnnonse);

    }
}
