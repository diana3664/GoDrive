package models;

import org.sql2o.Connection;

import java.util.List;

public class Ratings {

    private String driver_name;
    private String comment;
    private int review;
    private int id;

    public Ratings (String driver_name, String comment, int review){
    this.driver_name = driver_name;
    this.comment = comment;
    this.review = review;
    }



    //getters
    public String getDriver_name() {
        return driver_name;
    }

    public String getComment() {
        return comment;
    }

    public int getReview() {
        return review;
    }

    public int getId() {
        return id;
    }


    //setters


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ratings)) return false;

        Ratings ratings = (Ratings) o;

        if (getReview() != ratings.getReview()) return false;
        if (getId() != ratings.getId()) return false;
        if (!getDriver_name().equals(ratings.getDriver_name())) return false;
        return getComment().equals(ratings.getComment());
    }

    @Override
    public int hashCode() {
        int result = getDriver_name().hashCode();
        result = 31 * result + getComment().hashCode();
        result = 31 * result + getReview();
        result = 31 * result + getId();
        return result;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO ratings (driver_name,comment,review) VALUES (:driver_name, :comment,:review);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("driver_name", this.driver_name)
                    .addParameter("comment", this.comment)
                    .addParameter("review", this.review)
                    .executeUpdate()
                    .getKey();
        }catch ( Exception e){}
    }

    public static List<Ratings> all() {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM ratings";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Ratings.class);
        }

    }

    public static Ratings find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM ratings WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Ratings.class);
        }
    }

    //delete
    public void deleteById(){
        try(Connection con = DB.sql2o.open()){
            String sql = "DELETE from ratings WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }


}
