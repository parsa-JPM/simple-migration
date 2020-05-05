package ir.codefather.migration.sql;

import java.util.function.Consumer;

/**
 * it responsible to run sql created by TableDetails
 */
public interface SQLRunner {
    /**
     * it used to create new table(schema)
     *
     * @param tableName            name of table
     * @param tableDetailsConsumer details of table such as columns and its details
     */
    void create(String tableName, Consumer<TableDetails> tableDetailsConsumer);
}
