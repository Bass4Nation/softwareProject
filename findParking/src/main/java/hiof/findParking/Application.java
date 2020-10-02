package hiof.findParking;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {
//    Laget for å teste hele prosjektet pluss nettsiden.

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        // ----------------------------Views---------------------------
        app.get("/", new VueComponent("test"));
        app.get("/test", new VueComponent("test"));

//        Må ha dette under i vue og endre "test" over og under til det du vil kalle vue filen.
//        <script>
//                Vue.component("test", {
//                        template: "#test",
//                data: () => ({
//                observations: [],
//              }),
//            });
//        </script>

    }
}
