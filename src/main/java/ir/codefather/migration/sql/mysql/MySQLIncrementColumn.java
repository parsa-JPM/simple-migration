package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.column.IncrementColumn;

public class MySQLIncrementColumn implements IncrementColumn {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
