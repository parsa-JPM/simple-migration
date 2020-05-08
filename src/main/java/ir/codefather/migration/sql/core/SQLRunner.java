package ir.codefather.migration.sql.core;

import java.util.function.Consumer;

/**
 * it responsible to run sql of migration and make changes in DB
 */
public interface SQLRunner {
    /**
     * it used to create new table(schema)
     *
     * @param tableName            name of table
     * @param tableDetailsConsumer details of table such as columns and its details
     */
    void create(String tableName, Consumer<TableModifier> tableDetailsConsumer);
}
