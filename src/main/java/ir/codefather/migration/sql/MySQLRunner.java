package ir.codefather.migration.sql;

import java.util.function.Consumer;

public class MySQLRunner implements SQLRunner {

    @Override
    public void create(String tableName, Consumer<TableDetails> tableDetailsConsumer) {
        TableDetails tableDetails = TableDetailsFactory.create(tableName);

        tableDetailsConsumer.accept(tableDetails);
    }
}
