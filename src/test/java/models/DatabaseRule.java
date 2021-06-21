package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule  extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/godrive_test", "postgres", "wildlife");

    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {

        }
    }

}
