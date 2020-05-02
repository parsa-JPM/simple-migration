package ir.codefather.migration.test;

import ir.codefather.migration.runner.MigrateInfo;
import ir.codefather.migration.runner.Migration;

/**
 * @author parsa
 *
 */
@MigrateInfo(version="2019.09.26.9.31.40")
public class CreateRoleTable implements Migration {

	public void up() {
		// TODO Auto-generated method stub
		System.out.println("up method in role migration");
	}

	public void down() {
		// TODO Auto-generated method stub
		
	}

}
