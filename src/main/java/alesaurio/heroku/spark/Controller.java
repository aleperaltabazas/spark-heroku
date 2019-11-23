package alesaurio.heroku.spark;

import spark.Request;
import spark.Response;

public class Controller {
    public String home(Request req, Response res) {
        return "Hello, world!";
    }
}