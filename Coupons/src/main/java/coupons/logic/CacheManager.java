package coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import coupons.beans.UserDataToMap;

@Component
public class CacheManager implements ICacheManager {

	private Map<Object, UserDataToMap> map;

	public CacheManager() {

		map = new HashMap<Object, UserDataToMap>();

	}

	@Override
	public void put(Object key, UserDataToMap value) {

		map.put(key, value);

	}

	@Override
	public Object get(Object key) {

		return map.get(key);

	}

	public Object getFirst() {

		for (Object userData : map.values()) {
			return userData;
		}
		return null;

	}

}
