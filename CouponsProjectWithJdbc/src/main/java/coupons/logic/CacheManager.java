package coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import coupons.beans.UserDataMap;

/**
 * create a cache manager
 * 
 * @author Lichay
 *
 */
@Component
public class CacheManager implements ICacheManager {

	private Map<Integer, UserDataMap> map;

	/**
	 * This function instantiate all references
	 */
	public CacheManager() {

		map = new HashMap<Integer, UserDataMap>();

	}

	// functions

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void put(Integer key, UserDataMap value) {

		map.put(key, value);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDataMap get(Integer key) {

		return map.get(key);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteFromMap(Integer key) {

		map.remove(key);

	}

	@Override
	public void showAll() {

		for (Integer item : map.keySet()) {
			System.out.println(item);
			System.out.println();
		}

	}

}
