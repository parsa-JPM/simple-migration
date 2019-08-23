package ir.codefather.migration.test;

import ir.codefather.migration.MigrationRunner;
import ir.codefather.migration.MySqlRunner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		new MigrationRunner().up();
		test("parararararr");
	}




	private static void test(String h) {
		var n = h;
		System.out.println(n);
	}
}
