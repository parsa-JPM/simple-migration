package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.core.ConnectionHolder;
import ir.codefather.migration.sql.core.SQLRunner;
import ir.codefather.migration.sql.core.TableModifier;
import ir.codefather.migration.sql.core.TableModifierFactory;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.function.Consumer;

public class MySQLRunner implements SQLRunner {

    @Override
    public void create(String tableName, Consumer<TableModifier> tableDetailsConsumer) {
        DSLContext create= DSL.using(ConnectionHolder.getInstance().getConnection(), SQLDialect.MYSQL);

        TableModifier tableDetails = TableModifierFactory.create(create.createTable(tableName));

        tableDetailsConsumer.accept(tableDetails);

        MySQLTableModifier details = (MySQLTableModifier) tableDetails;

        //TODO make a another class with name Drawer to apply changes in DB

    }
}
