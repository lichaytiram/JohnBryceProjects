package DB;

import BaseProgram.Customer;

public interface ICustomersDAO extends IMainDAO {

	void insert(Customer c) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(Customer c, int index) throws Exception;
}
