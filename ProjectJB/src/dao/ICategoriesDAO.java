package dao;

import dbdao.IMainDAO;

public interface ICategoriesDAO extends IMainDAO {

	void insert(String Name) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(String Name, int index) throws Exception;
}
