package ir.codefather.migration.test;

import ir.codefather.migration.runner.MigrateInfo;
import ir.codefather.migration.runner.Migration;
import ir.codefather.migration.sql.Schema;

/**
 * @author parsa
 * <p>
 * Test migration system
 */
@MigrateInfo(version = "2019.09.26.4.32.0")
public class CreateUserTable implements Migration {

    public void up() {
        Schema.create("users", (detail) -> {
            detail.increments("id");
            detail.string("name", 100);
            detail.timestamps();
        });
    }

    public void down() {
        Schema.drop("users");
    }

}
