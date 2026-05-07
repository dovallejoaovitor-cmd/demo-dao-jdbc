package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Books");
		System.out.println(dp);
		
		Seller seller = new Seller(2, "Bobson da Silva", "Bobson@gmail.com", new Date(), 2000.0, dp);
		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
