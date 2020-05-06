package ir.codefather.migration.sql.table;

import ir.codefather.migration.sql.mysql.MySQLTableDetails;

public class TableDetailsFactory {

    /**
     * create TableDetails instance
     *
     * @param tableName
     * @return TableDetails
     */
    public static TableDetails create(String tableName) {
        /**
         * now we just have mysql
         */
        return new MySQLTableDetails(tableName);
    }
}
