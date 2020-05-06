package ir.codefather.migration.sql.table;

import java.util.function.Consumer;

/**
 * This is a facade class that help client to generate sql of migration
 */
public class Schema {

    public static void create(String tableName, Consumer<TableDetails> details) {
        SQLRunner runner = SQLRunnerFactory.create();
        runner.create(tableName, details);
    }

    public static void table() {
    }

    public static void rename() {
    }

    public static void drop(String tableName) {
    }

}
