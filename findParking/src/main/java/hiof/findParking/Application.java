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

        // ----------------------------Front Page -------------------------
        app.get("/find-parking", new VueComponent("fylker"));

//        -------------------------User Page -----------------------------
        app.get("/find-parking/minSide/:bruker-id", new VueComponent("bruker"));

//        -------------------------User Page Annonser -----------------------------
        app.get("/find-parking/minSide/:bruker-id/annonser", new VueComponent("bruker-annonser"));

//      -------------------------- Creator Annonse page -------------------------
        app.get("/find-parking/creator", new VueComponent("creator"));

//      -------------------------- Alle annonser i valgte fylke -------------------------
        app.get("/find-parking/:alle-annonser-id", new VueComponent("alle-annonsene"));

//      -------------------------- Den valgte annonsen -------------------------
        app.get("/find-parking/:alle-annonser-id/annonser/:annonse-id", new VueComponent("annonse-detaljer"));
//      -------------------------- Ferdig ordre side -------------------------
        app.get("/find-parking/annonse/order", new VueComponent("order"));



//        ------------------------- Controller -----------------------------

        IRepository repository = new JsonRepository();
        Controller controller = new Controller(repository);
        AnnonseController annonseController = new AnnonseController(repository);

        //-----------------------------API -------------------------------

        app.get("/api/find-parking", controller :: getAllAnnonser);
        app.post("/api/find-parking/creator", controller :: createAnnonse);
        app.get("/api/find-parking/login", controller::getAllBrukere);
        app.get("/api/find-parking/minSide/:bruker-id", controller::getEnBrukere);
        app.get("/api/find-parking/minSide/:bruker-id/annonser", controller::getBrukerAnnonser);
        app.get("/api/find-parking/:alle-annonser-id", controller::getAnnonser);
        app.get("/api/find-parking/:alle-annonser-id/annonser",annonseController ::getAnnonser);
        app.get("/api/find-parking/:alle-annonser-id/annonser/:annonse-id", annonseController ::getAnnonse);

    }
}
