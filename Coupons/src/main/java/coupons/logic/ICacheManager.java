package coupons.logic;

//import coupons.beans.UserData;

public interface ICacheManager {

	void put(Object key, Object value);

	Object get(Object key);

	Object getFirst();

}
