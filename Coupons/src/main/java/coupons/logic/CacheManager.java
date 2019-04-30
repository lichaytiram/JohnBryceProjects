package coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import coupons.beans.UserDataMap;

@Component
public class CacheManager implements ICacheManager {

	private Map<Object, UserDataMap> map;

	public CacheManager() {

		map = new HashMap<Object, UserDataMap>();

	}

	@Override
	public void put(Object key, UserDataMap value) {

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
