package ir.codefather.migration.test;

import ir.codefather.migration.runner.MigrationRunner;
import ir.codefather.migration.sql.core.ConnectionHolder;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class New {
    public static void main(String[] args) {
        testJooq();
    }

    private static void testJooq() {
        String userName = "root";
        String password = "Parsa1376!#&^";
        String url = "jdbc:mysql://localhost:3306/test";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            ConnectionHolder.getInstance().setConnection(conn);
            new MigrationRunner().up();
//            create.createTableIfNotExists("books")
//                   .column("id", SQLDataType.INTEGER)
//                   .column("name", SQLDataType.VARCHAR(50))
//                    .execute();
//
//            create.dropTable("books").execute();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

}
