package ir.codefather.migration.runner;

import java.text.Collator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * this class responsible to sort migration classes(files) based on version
 * number
 *
 * @author parsa
 */
public class MigrationSorterImpl implements MigrationSorter {
    /**
     * get all migration classes
     */
    Set<Class<?>> migrationsClasses;

    /**
     * store sorted migrations
     */
    List<Class<? extends Migration>> sortedMigrations;


    /**
     * set list of migrations
     *
     * @param migrationsClasses
     */
    public MigrationSorterImpl(Set<Class<?>> migrationsClasses) {
        this.migrationsClasses = migrationsClasses;
    }


    /**
     * it will sort migartions and set those into Queue
     *
     * @return
     */
    public List<Class<? extends Migration>> sort() {

        sortedMigrations = migrationsClasses.stream()
                .sorted(this::migrationCompareTo)
                .map(klass -> (Class<? extends Migration>) klass)
                .collect(Collectors.toList());

          return sortedMigrations;
    }


    /**
     * implement a compareTo for using in sorted method of stream
     *
     * @param migration1 migration class one to compare
     * @param migration2 migration class two to compare
     * @return int
     */
    private int migrationCompareTo(Class<?> migration1,Class<?> migration2){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.H.m.s");
        MigrateInfo migration1Info = migration1.getAnnotation(MigrateInfo.class);
        MigrateInfo migration2Info = migration2.getAnnotation(MigrateInfo.class);
        LocalDateTime migration1Time = LocalDateTime.parse(migration1Info.version(), timeFormatter);
        LocalDateTime migration2Time = LocalDateTime.parse(migration2Info.version(), timeFormatter);

        return migration1Time.compareTo(migration2Time);
    }
}
