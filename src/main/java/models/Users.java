package models;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Objects;

public class Users {

    private int id;
    private String username;
    private String phone_no;
    private String location;
    private String driver_name;
    private int price;

    public Users(String username, String phone_no, String location, String driver_name, int price) {

    }

    //getters
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPhone_no(){
        return phone_no;
    }
    public String getLocation(){
        return location;
    }
    public String getDriver_name(){
        return driver_name;
    }
    public int getPrice(){
        return price;
    }

    //crud
    //create
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO users(username,phone_no,location,driver_name,price) VALUES (:username,:phone_no,:location,:driver_name,:price)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("username",this.username)
                    .addParameter("phone_no",this.phone_no)
                    .addParameter("location",this.location)
                    .addParameter("driver_name",this.driver_name)
                    .addParameter("price",this.price)
                    .executeUpdate()
                    .getKey();
        }
    }

    //read
    public static List<Users> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM users";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Users.class);
        }
    }

    public static Users find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM users WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Users.class);
        }
    }

    //update

    //delete
    public void deleteById(){
        try(Connection con = DB.sql2o.open()){
            String sql = "DELETE from users WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }
    
    //delete all
    public void delete(){
        String sql = "DELETE from users";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                username.equals(users.username) &&
                phone_no.equals(users.phone_no) &&
                location.equals(users.location) &&
                driver_name.equals(users.driver_name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(username,phone_no,location,driver_name,price);
    }

}
