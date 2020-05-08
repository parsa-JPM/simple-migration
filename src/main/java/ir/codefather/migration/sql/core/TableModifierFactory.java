package ir.codefather.migration.sql.core;

import ir.codefather.migration.sql.mysql.MySQLTableModifier;
import org.jooq.CreateTableColumnStep;

public class TableModifierFactory {

    /**
     * create TableDetails instance
     *
     * @param columnStep
     * @return TableDetails
     */
    public static TableModifier create(CreateTableColumnStep columnStep) {
        /**
         * now we just have mysql
         */
        return new MySQLTableModifier(columnStep);
    }
}
