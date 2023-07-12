package com.prolim.EndProjectP3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	private static Admin admin= new Admin("admin","admin");
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PurchaseHistoryRepo purchaseRepo;
	@Autowired
	private ProductRepo productRepo;
	@GetMapping("/isValid")
	public static String isValid(@RequestBody Admin a) {
		if(admin.getUsername().equals(a.getUsername())) {
			if(admin.getPassword().equals(a.getPassword())) {
				return "valid";
			}else {
				return "wrong password";
			}
		}
		return "Invalid username";
	}
	@PostMapping("/ChangePassword")
	public static String ChangePassword(@RequestBody Admin a) {
		admin.setUsername(a.getUsername());
		admin.setPassword(a.getPassword());
		return "Password Updated";
	}
	@GetMapping("/ListUsers")
	public List<User> getAllUser(){
		List<User> resList= userRepo.findAll();
		return resList;
	}
	@GetMapping("/isPresent")
	public User findUser(@RequestParam int uid) throws Exception {
		Optional<User> a= userRepo.findById(uid);
		if(a.isPresent()) {
			return a.get();
		}
		throw new Exception("User is not Present");
	}
	@GetMapping("/findByCategory")
	  public List<PurchaseHistory> getPurchaseReportByCategories(@RequestParam String category) {
		List<PurchaseHistory> totaList= purchaseRepo.findAll();
		List<PurchaseHistory> purchases = new ArrayList();
	    for (PurchaseHistory purchase : totaList) {
	      if (category.equals(purchase.getCname())) {
	        purchases.add(purchase);
	      }
	    }
	    return purchases;
	  }
	@GetMapping("/findByDate")
	public List<PurchaseHistory> findByDate(@RequestParam Date date) throws Exception{
		List<PurchaseHistory> a= purchaseRepo.findBytDate(date);
		return a;
	}
	@GetMapping("/PurchaseReport")
	public List<PurchaseHistory>GetReport(){
		List<PurchaseHistory> resHistories= purchaseRepo.findAll();
		return resHistories;
	}
	@PostMapping("/AddProduct")
	public Product addProduct(@RequestBody Product product ) {
		productRepo.save(product);
		return product;
	}
	@GetMapping("/getProduct")
	public Product getProduct(@RequestParam int id) throws Exception{
			Optional<Product> product= productRepo.findById(null);
			if(product.isPresent()) {
				return product.get();
			}
			throw new Exception("Product not found");
	}
	@GetMapping("/UpdateProduct")
	public Product updateProduct(@RequestBody Product p) throws Exception {
		Optional<Product> x= productRepo.findById(p.getPid());
		if(x.isPresent()) {
			productRepo.save(p);
			return p;
		}
		throw new Exception("Product not there");
	}
	@DeleteMapping("/DeleteProduct")
	public String deleteProduct(@RequestParam int Pid)  {
		Optional<Product> x= productRepo.findById(Pid);
		if(x.isPresent()) {
			productRepo.delete(x.get());
			return "Done";
		}
		return "Product not there";
	}
	@GetMapping("/getAllProduct")
	public List<Product>getAllProduct(@RequestParam int id) throws Exception{
			List<Product> resList= productRepo.findAll();
			return resList;
	}
}