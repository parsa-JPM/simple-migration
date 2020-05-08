package ir.codefather.migration.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

/**
 * this class just responsible to detect migration files and run their up or
 * down method based on their version number.(it follows Composite pattern)
 *
 * @author parsa
 */
public class MigrationRunner implements Migration {

    //TODO inject dependencies to this class

    /**
     * run new migrations
     */
    public void up() {
        Reflections reflections = new Reflections("ir.codefather");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MigrateInfo.class);
        //TODO inject from construcort
        MigrationSorter sorter = new MigrationSorterImpl(classes);

        List<Class<? extends Migration>> sortedClasses = sorter.sort();

        sortedClasses.forEach(this::callRunMethod);
    }

    /**
     * call run method of migrations
     *
     * @param migrationClass class object of migration class
     */
    private void callRunMethod(Class<? extends Migration> migrationClass) {
        try {
            Migration migration = migrationClass.getConstructor().newInstance();
            Method method = migrationClass.getMethod("up");
            method.invoke(migration);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * roll back latest ran migrations. rolls back the last "batch" of migrations,
     * which may include multiple migration files
     */
    @Override
    public void down() {

    }
}
