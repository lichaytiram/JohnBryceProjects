package coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import coupons.beans.UserDataMap;

@Component
public class CacheManager implements ICacheManager {

	private Map<Integer, UserDataMap> map;

	public CacheManager() {

		map = new HashMap<Integer, UserDataMap>();

	}

	@Override
	public void put(Integer key, UserDataMap value) {

		map.put(key, value);

	}

	@Override
	public UserDataMap get(Integer key) {

		return map.get(key);

	}

	public void deleteFromMap(Integer key) {

		map.remove(key);

	}

	public void all() {

		System.out.println(map);

	}

}
