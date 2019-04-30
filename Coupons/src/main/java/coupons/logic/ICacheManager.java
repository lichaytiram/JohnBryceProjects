package coupons.logic;

import coupons.beans.UserDataMap;

public interface ICacheManager {

	void put(Object key, UserDataMap value);

	Object get(Object key);

	Object getFirst();

}
