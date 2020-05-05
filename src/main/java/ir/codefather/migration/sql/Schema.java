package ir.codefather.migration.sql;

import java.util.function.Consumer;
import java.util.function.Supplier;

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

    public static void drop() {
    }

}
