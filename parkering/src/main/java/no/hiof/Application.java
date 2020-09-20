package no.hiof;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        // ----------------------------Views---------------------------
        app.get("/", new VueComponent("test"));
        app.get("/test", new VueComponent("test"));
//
//        app.before("/", ctx -> ctx.redirect("/planet-systems"));
//        app.get("/planet-systems", new VueComponent("planet-system-overview"));
//        app.get("/planet-systems/:planet-system-id/", new VueComponent("planet-system-detail"));
//        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));
//        app.get("/planet-systems/:planet-system-id/planets/:planet-id/", new VueComponent("planet-detail"));
//        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));
//
////        IUniverseRepository universeRepository = new UniverseRepository();
//        IUniverseRepository universeRepository = new UniverseJSONRepository();
////        IUniverseRepository universeRepository = new UniverseCSVRepository();
//
////        Vet ikke om vi skulle ha det slik eller ei, men gjorde repositoryene slik at man må bare
////        kommentere ut hva hvem som skal brukes.
////        Pluss må passe på at filenNavnet blir endret i begge controllerene for create a planet og update a planet.
//
//        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);
//
//        PlanetController planetController = new PlanetController(universeRepository);
//
//        //-----------------------------API -------------------------------
//
//        app.get("/api/planet-systems/", planetSystemController :: getAllePlanetSystemer);
//        app.get("/api/planet-systems/:planet-system-id/", planetSystemController :: getAllePlaneterIPlanetSystemet);
//        app.post("/api/planet-systems/:planet-system-id/createplanet/", planetSystemController :: createPlanetInSystem);
//        app.get("/api/planet-systems/:planet-system-id/planets", planetController :: getAllePlaneter);
//
//        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController :: getOnePlanet);
//        app.post("/api/planet-systems/:planet-system-id/planets/:planet-id/update", planetController :: updatePlanet);
//        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", planetController :: deletePlanet);

    }
}
