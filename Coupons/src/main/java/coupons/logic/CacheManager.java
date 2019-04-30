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

		System.out.println("the key is: " + key);
		for (Object keys : map.keySet()) {
			System.out.println("the key is: " + keys);
			System.out.println("value is 1: " + map.get(key));
			System.out.println("value is 2: " + map.get(keys));
			if (key == keys)
				System.out.println("yes1");
			else
				System.out.println("no1");
			if (key.equals(keys))
				System.out.println("yes2");
			else
				System.out.println("no2");
		}
		System.out.println("done");
		return map.get(key);

	}

}
