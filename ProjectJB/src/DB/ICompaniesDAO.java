package DB;

import BaseProgram.Company;

public interface ICompaniesDAO extends IMainDAO {

	void insert(Company c) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(Company c, int index) throws Exception;
}
