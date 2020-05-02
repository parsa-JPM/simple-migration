package ir.codefather.migration.runner;

import java.util.List;

/**
 * Sort migration classes to run
 */
public interface MigrationSorter {
    List<Class<? extends Migration>> sort();
}
