package ir.codefather.migration.sql.core;

import ir.codefather.migration.sql.column.Column;
import ir.codefather.migration.sql.column.IncrementColumn;

/**
 * This class's responsible is draw schema detail (columns)
 */
public interface TableModifier {

    IncrementColumn bigIncrements(String name);

    IncrementColumn increments(String name);

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
}
