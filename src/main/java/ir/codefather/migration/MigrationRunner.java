package ir.codefather.migration;

import java.util.Set;

import org.reflections.Reflections;

public class MigrationRunner {
	// TODO run migrations class based on their version
	// TODO versions are numbers with dot separated that left numbers is in priority





	/**
	 * run new migrations
	 */
	public void up() {
		Reflections reflections = new Reflections("ir.codefather");
		Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MigrateInfo.class);
		 System.out.println(classes.size());
	}




	/**
	 * roll back latest ran migrations. rolls back the last "batch" of migrations,
	 * which may include multiple migration files
	 */
	public void rollBack() {
	}

}
