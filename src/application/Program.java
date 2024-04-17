package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Department obj = new Department(1, "Books");
		//Seller seller = new Seller(21, "DinhoOGordinho",
				//"DinhoGordinho@gmail.com",new Date(), 3000.0, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); //seller from daofactory for tests
		
		System.out.println("=== test, findById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== test2, SellerByDepartement ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		/////////////////////
		System.out.println("\n=== test3, SellerByDepartement ===");
		list = sellerDao.findALL();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		////////
		System.out.println("\n=== test4, SellerInsert ===");
		Seller newSeller = new Seller(
				null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted!, new id: " + newSeller.getId());
		
		 ///////////
		System.out.println("\n=== test5, SellerUpdate ===");
		seller = sellerDao.findById(1);
		seller.setName("barney");
		sellerDao.update(seller);
		System.out.println("update complete!");
		
		
	}

}
