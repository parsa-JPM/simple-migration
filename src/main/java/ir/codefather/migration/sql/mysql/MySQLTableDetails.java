package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.column.Column;
import ir.codefather.migration.sql.column.IncrementColumn;
import ir.codefather.migration.sql.table.TableDetails;

public class MySQLTableDetails implements TableDetails {

    private final String tableName;
    public String generatedSQL = "";

    public MySQLTableDetails(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public IncrementColumn bigIncrements(String name) {
        return null;
    }

    @Override
    public IncrementColumn increments(String name) {
        generatedSQL += " create Id in table " + tableName;

        return null;
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
        // col = new StringColumn(name,length)
        // strings.add(col)
        // return col
        return null;
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

    @Override
    public void dropColumn(String... names) {

    }

    @Override
    public void renameColumn(String from, String to) {

    }

    @Override
    public String toString() {
        return generatedSQL;
    }
}
