package ir.codefather.migration;

/**
 * 
 * @author parsa
 *
 *It's base of all migration class
 */
public interface Migration {
	/**
	 * run migration command
	 */
	public void up();
	/**
	 * revert migration command
	 */
	public void down();

}
