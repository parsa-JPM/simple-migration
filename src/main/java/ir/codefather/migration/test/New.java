package ir.codefather.migration.test;

import ir.codefather.migration.runner.MigrationRunner;
import ir.codefather.migration.sql.column.ColumnFactory;

public class New {
	public static void main(String[] args) {

//		new MigrationRunner().up();

		System.out.println(ColumnFactory.create("string"));
	}

}
