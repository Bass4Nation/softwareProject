package hiof.findParking;

import hiof.findParking.repository.*;
import hiof.findParking.Controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {
//    Laget for å teste hele prosjektet pluss nettsiden.

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        // ----------------------------Views---------------------------
        app.get("/alleAnnonser", new VueComponent("alleAnnonser"));
        app.before("/", ctx -> ctx.redirect("/alleAnnonser"));

        app.get("/annonse", new VueComponent("annonse"));


        IRepository repository = new Repository();
        Controller controller = new Controller(repository);

        //-----------------------------API -------------------------------

        app.get("/api/alleAnnonser", controller :: getAllAnnonser);
//        app.get("/api/alleAnnonser/:annonse", controller :: annonse);



    }
}
