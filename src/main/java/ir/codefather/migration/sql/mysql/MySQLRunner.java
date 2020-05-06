package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.table.SQLRunner;
import ir.codefather.migration.sql.table.TableDetails;
import ir.codefather.migration.sql.table.TableDetailsFactory;

import java.util.function.Consumer;

public class MySQLRunner implements SQLRunner {

    @Override
    public void create(String tableName, Consumer<TableDetails> tableDetailsConsumer) {
        TableDetails tableDetails = TableDetailsFactory.create(tableName);
        System.out.println("before run " + tableDetails);
        tableDetailsConsumer.accept(tableDetails);
        System.out.println("after run " + tableDetails.toString());
    }
}
