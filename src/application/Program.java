package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Books");
		Locale.setDefault(Locale.US);
		System.out.println(dp);
		
		Scanner sc = new Scanner(System.in);
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findById ===");
		List<Seller> list = sellerDao.findByDepartment(dp);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: seller INSERT ===");
		
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 2000.0, dp);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
				
		System.out.println("=== TEST 5: seller UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("wainemartha@gmail.com");
		seller.setBaseSalary(4200.0);
		sellerDao.update(seller);
		
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 6: seller DELETE ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
