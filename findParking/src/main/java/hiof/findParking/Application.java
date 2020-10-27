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
        app.get("/", new VueComponent("annonse"));
        app.get("/annonse", new VueComponent("annonse"));

//        Må ha dette under i vue og endre "test" over og under til det du vil kalle vue filen.
//        <script>
//                Vue.component("test", {
//                        template: "#test",
//                data: () => ({
//                observations: [],
//              }),
//            });
//        </script>

        IRepository repository = new Repository();
        Controller controller = new Controller(repository);

        //-----------------------------API -------------------------------

        app.get("/api/alleAnnonser", controller :: alleAnnonser);
        app.get("/api/alleAnnonser/:annonse", controller :: annonse);



    }
}
