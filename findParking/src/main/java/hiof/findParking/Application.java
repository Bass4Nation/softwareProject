package hiof.findParking;

import hiof.findParking.Controller.AnnonseController;
import hiof.findParking.repository.*;
import hiof.findParking.Controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {
//    Laget for å teste hele prosjektet pluss nettsiden.

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7009);

        app.config.enableWebjars();

        // ----------------------------Views---------------------------
        app.before("/", ctx -> ctx.redirect("/alle-annonser/Alle%20Annonser"));

        app.get("/alle-annonser", new VueComponent("alle-annonser"));
        app.get("/alle-annonser/:alle-annonser-id", new VueComponent("alle-annonsene"));
        app.get("/alle-annonser/:alle-annonser-id/annonser/:annonse-id", new VueComponent("annonse-detaljer"));

//        app.get("/alleAnnonser/:annonse", new VueComponent("annonse"));



        IRepository repository = new Repository();
        Controller controller = new Controller(repository);
        AnnonseController annonseController = new AnnonseController(repository);

        //-----------------------------API -------------------------------

        app.get("/api/alle-annonser", controller :: getAllAnnonser);
        app.get("/api/alle-annonser/:alle-annonser-id", controller::getAnnonser);

        app.get("/api/alle-annonser/:alle-annonser-id/annonser",annonseController ::getAnnonser);
        app.get("/api/alle-annonser/:alle-annonser-id/planets/:annonse-id", annonseController ::getAnnonser);

//        app.get("/api/alleAnnonser/:annonse", controller :: annonse);



    }
}
