package alesaurio.heroku.spark;

import spark.Spark;

public class Main {
    private Controller controller;

    public Main() {
        controller = new Controller();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Spark.port(getHerokuAssignedPort());
        Spark.get("/home", (req, res) -> controller.home(req, res));
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 9290; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}