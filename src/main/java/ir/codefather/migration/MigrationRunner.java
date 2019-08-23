package ir.codefather.migration;

import java.util.Set;

import org.reflections.Reflections;

/**
 * this class just responsible to detect migration files and run their up or
 * down method based on their version number.
 * 
 * 
 * @author parsa
 *
 */
public class MigrationRunner {
	// TODO run migrations class based on their version
	// TODO versions are numbers with dot separated that left numbers is in priority
	// TODO set ran migrations to DB and prevent duplicate run and other call

	/**
	 * run new migrations
	 */
	public void up() {
		Reflections reflections = new Reflections("ir.codefather");
		Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MigrateInfo.class);
		MigrationSorter sorter = new MigrationSorter(classes);
		sorter.sort();
		System.out.println(sorter.compareVersion("2019.10.26.9.32.40", "2019.09.26.9.32.40"));
	}




	/**
	 * roll back latest ran migrations. rolls back the last "batch" of migrations,
	 * which may include multiple migration files
	 */
	public void rollBack() {
	}

}
