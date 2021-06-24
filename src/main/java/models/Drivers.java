package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Drivers {
    private int id;
    private String driver_name;

    public Drivers( String driver_name) {
        this.driver_name = driver_name;
    }

    //getters


    public int getId(){
        return id;
    }
    public String getDriver_name(){
        return driver_name;
    }

    //crud


    //create


    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO drivers(driver_name) VALUES (:driver_name)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("driver_name",this.driver_name)
                    .executeUpdate()
                    .getKey();
        }
    }

    //read
    public static List<Drivers> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM drivers";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Drivers.class);
        }
    }

    public static Drivers find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM drivers WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Drivers.class);
        }
    }

    //update

    //delete
    public void deleteById(){
        try(Connection con = DB.sql2o.open()){
            String sql = "DELETE from drivers WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }

    //delete all
    public void delete(){
        String sql = "DELETE from drivers";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Drivers driver = (Drivers) o;
        return id == driver.id &&
                driver_name.equals(driver.driver_name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(driver_name);
    }

}
