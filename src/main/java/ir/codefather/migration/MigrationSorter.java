package ir.codefather.migration;

import java.util.Deque;
import java.util.Set;

/**
 * 
 * this class responsible to sort migration classes(files) based on version
 * number
 * 
 * @author parsa
 *
 */
public class MigrationSorter {
	/**
	 * get all migration classes
	 */
	Set<Class<?>> migrationsClasses;

	/**
	 * store sorted migrations
	 */
	Deque<Class<?>> sortedMigrations;




	/**
	 * set list of migrations
	 * 
	 * @param migrationsClasses
	 */
	public MigrationSorter(Set<Class<?>> migrationsClasses) {
		this.migrationsClasses = migrationsClasses;
	}




	/**
	 * it will sort migartions and set those into Queue
	 * 
	 * @return
	 */
	public Deque<Class<?>> sort() {
		for (Class<?> klass : migrationsClasses) {
			MigrateInfo migrateAnnotation = (MigrateInfo) klass.getAnnotation(MigrateInfo.class);
			System.out.println(migrateAnnotation.version());
		}
		return null;
	}




	/**
	 * compare two versions with each other when v1 has been garter return value
	 * will be 1.
	 * 
	 * 
	 * @param v1
	 * @param v2
	 * @return short
	 */
	public short compareVersion(String v1, String v2) {
		String[] spilitedV1 = v1.split("\\.");
		String[] spilitedV2 = v2.split("\\.");
		
		if (spilitedV1.length < spilitedV2.length)
			return compareBaseOnV1Length(spilitedV1, spilitedV2);

		if (spilitedV1.length > spilitedV2.length)
			return compareBaseOnV2Length(spilitedV1, spilitedV2);

		return compareBaseOnEqualLength(spilitedV1, spilitedV2);
	}




	/**
	 * iterate base of v1 spilited length in this situation default case is that v1
	 * is bigger except one of v2 digit in the same domain(length) of v1 has been
	 * bigger than v1
	 * 
	 * @param v1
	 * @param v2
	 * @return short
	 */
	private short compareBaseOnV1Length(String[] v1, String[] v2) {
		for (int i = 0; i < v1.length; i++) {
			Float versionNum1 = Float.parseFloat(v1[i]);
			Float versionNum2 = Float.parseFloat(v2[i]);

			if (versionNum1 < versionNum2)
				return -1;
		}

		return 1;
	}




	/**
	 * iterate base of v2 spilited length in this situation default case is that v2
	 * is bigger except one of v1 digit in the same domain(length) of v2 has been
	 * bigger than v2
	 * 
	 * @param v1
	 * @param v2
	 * @return short
	 */
	private short compareBaseOnV2Length(String[] v1, String[] v2) {
		for (int i = 0; i < v2.length; i++) {
			Float versionNum1 = Float.parseFloat(v1[i]);
			Float versionNum2 = Float.parseFloat(v2[i]);

			if (versionNum1 > versionNum2)
				return 1;
		}

		return -1;
	}




	/**
	 * this method have been called when length of versions were equal
	 * 
	 * 
	 * @param v1
	 * @param v2
	 * @return short
	 */
	private short compareBaseOnEqualLength(String[] v1, String[] v2) {
		for (int i = 0; i < v2.length; i++) {
			Float versionNum1 = Float.parseFloat(v1[i]);
			Float versionNum2 = Float.parseFloat(v2[i]);

			System.out.println(versionNum1 + " compare with " + versionNum2);
			if (versionNum1 > versionNum2)
				return 1;
			if (versionNum1 < versionNum2)
				return -1;
		}

		return 0;
	}
}
