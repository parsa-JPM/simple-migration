package ir.codefather.migration.sql.column;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.Set;

public class ColumnFactory {

    /**
     * find appropriate column class with this signature name :
     * database name + column type name + Column word
     *
     * @param columnType
     * @return Column
     */
    public static Column create(String columnType) {
        Class<? extends Column> columnClass = findBestClass(columnType);

        return createNewInstance(columnClass);
    }


    /**
     * find class object of correct concrete class of Column type
     *
     * @param columnType
     * @return Class<? extends Column>
     */
    private static Class<? extends Column> findBestClass(String columnType) {
        // package prefix is true I want looking for anywhere
        Reflections reflections = new Reflections("ir.codefather");
        Set<Class<? extends Column>> columns = reflections.getSubTypesOf(Column.class);
        String database = getDatabaseName();
        String className = database.concat(columnType).concat("Column");
        Optional<Class<? extends Column>> classOptional = searchInClasses(columns, className);

        if (classOptional.isPresent())
            return classOptional.get();

        return searchInClasses(columns, database.concat("BaseColumn")).get();
    }

    /**
     * detect which database is used
     *
     * @return String
     */
    private static String getDatabaseName() {
        //TODO make it dynamic
        return "MySQL";
    }

    /**
     * search class name in set of classes
     *
     * @param columns
     * @param withName
     * @return Optional<Class < ? extends Column>>
     */
    private static Optional<Class<? extends Column>> searchInClasses(Set<Class<? extends Column>> columns, String withName) {
        return columns.stream().filter(klass -> klass
                .getSimpleName()
                .equalsIgnoreCase(withName))
                .findFirst();
    }

    /**
     * create new instance of founded class
     *
     * @param columnClass
     * @return Column
     */
    private static Column createNewInstance(Class<? extends Column> columnClass) {
        try {
            return columnClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
