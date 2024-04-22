package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = new Department(null, "HDs");
		
		///test
		
		departmentDao.update(dep);
		System.out.println("update complete");
		
		departmentDao.deleteById(dep.getId());;
		System.out.println("delete completed, your id is: " + dep.getName());
		
		departmentDao.insert(dep);
		System.out.println("insert complete, your new department Id: " + dep.getId());
		
		
		
		
		
		
		
		
	}

}
