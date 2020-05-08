package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.column.Column;
import ir.codefather.migration.sql.column.ColumnFactory;
import ir.codefather.migration.sql.column.IncrementColumn;
import ir.codefather.migration.sql.column.IncrementFactory;
import ir.codefather.migration.sql.core.TableModifier;
import org.jooq.CreateTableColumnStep;
import org.jooq.impl.SQLDataType;

public class MySQLTableModifier implements TableModifier {

    /**
     * it will interact with Jooq
     */
    private final CreateTableColumnStep columnStep;

    public MySQLTableModifier(CreateTableColumnStep columnStep) {
        this.columnStep = columnStep;
    }


    @Override
    public IncrementColumn bigIncrements(String name) {
        return null;
    }

    @Override
    public MySQLIncrementColumn increments(String name) {
        IncrementColumn incrementColumn = IncrementFactory.create();
        incrementColumn.setName(name);

        return (MySQLIncrementColumn) incrementColumn;
    }

    @Override
    public Column timestamps() {
        return null;
    }

    @Override
    public Column date(String name) {
        return null;
    }

    @Override
    public Column dateTime(String name) {
        return null;
    }

    @Override
    public Column string(String name, int length) {

        //TODO we must provide other features like nullable and index and ... so we need this obj late
        // Todo we can use map(name -> Column)
        columnStep.column(name, SQLDataType.VARCHAR(length));


        return new MySQLBaseColumn();
    }

    @Override
    public Column text(String name) {
        return null;
    }

    @Override
    public Column mediumText(String name) {
        return null;
    }

    @Override
    public Column longText(String name) {
        return null;
    }

    @Override
    public Column intCol(String name) {
        return null;
    }

    @Override
    public Column longCol(String name) {
        return null;
    }

    @Override
    public Column charCol(String name) {
        return null;
    }

    @Override
    public Column floatCol(String name) {
        return null;
    }

    @Override
    public Column booleanCol(String name) {
        return null;
    }
}
