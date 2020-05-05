package ir.codefather.migration.sql;

public class SQLRunnerFactory {
    /**
     * It must return sql runner base on database connection
     *
     * @return SQLRunner
     */
    public static SQLRunner create(){
        /**
         * now we just have mysql
         */
        return new MySQLRunner();
    }
}
