package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = new Department(95, "HDs"); // testing error
		Department depInse = new Department(null, "Batteries");
		
		
		
		//departmentDao.update(dep);
		//System.out.println("update complete");
		
		
		departmentDao.deleteById(5);;
		System.out.println("delete completed");
		
		
		//departmentDao.insert(depInse);
		//System.out.println("insert complete, your new department Id: " + depInse.getId());
		
		
		
		
		
		
		
		
	}

}
