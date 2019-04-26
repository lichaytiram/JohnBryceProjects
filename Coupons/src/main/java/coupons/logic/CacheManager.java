package coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

//import coupons.beans.UserData;

@Component
public class CacheManager implements ICacheManager {

	private Map<Object, Object> map;

	public CacheManager() {

		map = new HashMap<Object, Object>(); // try delete <Integer, UserData> and change for it

	}

	@Override
	public void put(Object key, Object value) {

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
