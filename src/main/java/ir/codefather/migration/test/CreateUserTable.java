package ir.codefather.migration.test;

import ir.codefather.migration.runner.MigrateInfo;
import ir.codefather.migration.runner.Migration;

/**
 * 
 * @author parsa
 *
 *         Test migration system
 */
@MigrateInfo(version = "2019.09.26.4.32.0")
public class CreateUserTable implements Migration {

	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Up in user");
	}

	public void down() {
		// TODO Auto-generated method stub

	}

}
