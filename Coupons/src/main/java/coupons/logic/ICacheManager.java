package coupons.logic;

import coupons.beans.UserDataMap;

public interface ICacheManager {

	void put(Integer key, UserDataMap value);

	UserDataMap get(Integer key);

	public void deleteFromMap(Integer key);

	public void all();

}
