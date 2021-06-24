package models;

import org.sql2o.Connection;

import java.util.List;

public class Locations {
    private int id;
    private String location;
    private int price;

    public Locations(String location,int price){
        this.location = location;
        this.price = price;
    }

    public static List<Locations> all() {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM locations";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Locations.class);
        }
    }

    public static Locations find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM locations WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Locations.class);
        }
    }

    //getters
    public int getId(){
        return id;
    }
    public String getLocation(){
        return location;
    }
    public int getPrice(){
        return price;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO locations (location,price) VALUES (:location,:price)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("location",this.location)
                    .addParameter("price",this.price)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void deleteById() {
        try(Connection con = DB.sql2o.open()){
            String sql = "DELETE from locations WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }

    public void delete() {
        String sql = "DELETE from locations";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}
