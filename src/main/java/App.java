import models.Users;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/login",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"login.hbs");
        },new HandlebarsTemplateEngine());

        get("/user/request",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"request-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/user/request/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String username = request.params("username");
            String phone_no = request.params("phone_no");
            String location = request.params("location");
            String driver_name = request.params("driver_name");
            int price = Integer.parseInt(request.params("price"));
            Users users = new Users(username,phone_no,location,driver_name,price);
            users.save();
            return new ModelAndView(model,"request-success.hbs");
        },new HandlebarsTemplateEngine());

        get("/admin",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"admin-page.hbs");
        },new HandlebarsTemplateEngine());

    }
}
