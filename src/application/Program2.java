package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = new Department(95, "HDs"); // testing error -- deleteById
		Department depInsert = new Department(null, "Batteries");
		
		List<Department> listall = new ArrayList<>();
		listall = departmentDao.findALL();
		System.out.println(listall);
		
		/*
		dep = departmentDao.findById(2);
		System.out.println(dep);
		
		departmentDao.update(dep);
		System.out.println("update complete");
		
		
		departmentDao.deleteById(5);;
		System.out.println("delete completed");
		
		
		departmentDao.insert(depInsert);
		System.out.println("insert complete, your new department Id: " + depInsert.getId());
		
		*/
		
		
		
		
		
		
		
		
	}

}
