package ir.codefather.migration.sql.column;

public interface Column {
    void index();

    void first();

    void comment();

    void charset();

    void collation();

    void after(String name);
}
