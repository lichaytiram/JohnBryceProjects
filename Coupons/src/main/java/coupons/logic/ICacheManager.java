package coupons.logic;

import coupons.beans.UserData;

public interface ICacheManager {

	void put(Object key, UserData value);

	Object get(Object key);

	Object getFirst();

}
