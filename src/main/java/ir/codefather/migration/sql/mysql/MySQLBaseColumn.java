package ir.codefather.migration.sql.mysql;

import ir.codefather.migration.sql.column.Column;

public class MySQLBaseColumn implements Column {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void index() {

    }

    @Override
    public void first() {

    }

    @Override
    public void comment() {

    }

    @Override
    public void charset() {

    }

    @Override
    public void collation() {

    }

    @Override
    public void after(String name) {

    }
}
