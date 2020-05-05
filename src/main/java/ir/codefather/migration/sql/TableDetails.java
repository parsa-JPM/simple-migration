package ir.codefather.migration.sql;

/**
 * This class's responsible is draw schema detail
 */
public interface TableDetails {

    Column bigIncrements(String name);

    Column increments(String name);

    Column timestamps();

    Column date(String name);

    Column dateTime(String name);

    Column string(String name, int length);

    Column text(String name);

    Column mediumText(String name);

    Column longText(String name);

    Column intCol(String name);

    Column longCol(String name);

    Column charCol(String name);

    Column floatCol(String name);

    Column booleanCol(String name);

    void dropColumn(String... names);

    void renameColumn(String from, String to);

}
