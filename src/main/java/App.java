import models.Drivers;
import models.Locations;
import models.Ratings;
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
            model.put("drivers",Drivers.all());
            model.put("locations",Locations.all());
            return new ModelAndView(model,"request-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/user/request/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String username = request.queryParams("username");
            String phone_no = request.queryParams("phone_no");
            String location = request.queryParams("location");
            String driver_name = request.queryParams("driver_name");
            int price = Integer.parseInt(request.queryParams("price"));
            Users testUser = new Users(username,phone_no,location,driver_name,price);
            testUser.save();
            model.put("users",Users.all());
            return new ModelAndView(model,"request-success.hbs");
        },new HandlebarsTemplateEngine());

        post("/admin/driver/create",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String driver_name = request.queryParams("driver_name");
            Drivers drivers = new Drivers(driver_name);
            drivers.save();
            model.put("drivers",Drivers.all());
            return new ModelAndView(model,"driverSuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/admin",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"admin-page.hbs");
        },new HandlebarsTemplateEngine());

        get("/admin/location",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"location.hbs");
        }, new HandlebarsTemplateEngine());

        post("/admin/location/add",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String location = request.queryParams("location");
            int price = Integer.parseInt(request.queryParams("price"));
            Locations locations = new Locations(location,price);
            locations.save();
            model.put("locations",Locations.all());
            return new ModelAndView(model,"location-success.hbs");
        },new HandlebarsTemplateEngine());



        get("/rating/create", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("drivers",Drivers.all());
            return new ModelAndView(model, "ratings-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/rating/create/new", (request,response)-> {
            Map<String, Object> model = new HashMap<>();

            String RatingSelected = request.queryParams("RatingSelected");
            String comment = request.queryParams("comment");
           int review =Integer.parseInt(request.queryParams("review")) ;
            Ratings ratings = new Ratings(RatingSelected,comment,review);
            ratings.save();
            model.put("ratings", ratings);
            return new ModelAndView(model, "successRatings.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
