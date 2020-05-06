package ir.codefather.migration.sql.column;

import ir.codefather.migration.sql.mysql.MySQLIncrementColumn;

public class IncrementFactory {
    public static IncrementColumn create() {
        /**
         * it must return correct concrete class base on database
         * now it is hard-coded
         */
        return new MySQLIncrementColumn();
    }
}
