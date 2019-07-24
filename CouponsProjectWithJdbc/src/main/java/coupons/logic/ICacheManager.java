package coupons.logic;

import coupons.beans.UserDataMap;

/**
 * This interface will implement by class cacheManager
 * 
 * @author Lichay
 *
 */
public interface ICacheManager {

	/**
	 * @param key   Receive a key
	 * @param value Receive an user data map
	 */
	void put(Integer key, UserDataMap value);

	/**
	 * @param key Receive a key
	 * @return This function return an user data map
	 */
	UserDataMap get(Integer key);

	/**
	 * @param key Receive a key and delete it from cacheManager
	 */
	public void deleteFromMap(Integer key);
	
	public void showAll();

}
