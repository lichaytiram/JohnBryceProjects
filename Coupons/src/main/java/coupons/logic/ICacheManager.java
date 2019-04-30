package coupons.logic;

import coupons.beans.UserDataToMap;

public interface ICacheManager {

	void put(Object key, UserDataToMap value);

	Object get(Object key);

	Object getFirst();

}
