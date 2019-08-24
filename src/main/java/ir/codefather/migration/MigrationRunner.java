package ir.codefather.migration;

import java.util.List;
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
		System.out.println("before sort");
		List<Class<?>> sortedClasses = sorter.sort();
		System.out.println("after sort");

		sortedClasses.forEach(action->System.out.println(action.getName()));
	}




	/**
	 * roll back latest ran migrations. rolls back the last "batch" of migrations,
	 * which may include multiple migration files
	 */
	public void rollBack() {
	}

}
