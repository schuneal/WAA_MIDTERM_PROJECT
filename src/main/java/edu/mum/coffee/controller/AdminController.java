package edu.mum.coffee.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class AdminController {
	@Resource
	private PersonService personService;
	@Resource
	private ProductService productService;
	
	@RequestMapping(value="/createProduct")
	public String createProductGet(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "createProduct";
	}
	
	@RequestMapping(value="/createProduct", method=RequestMethod.POST)
	public String createProductPOST(@Valid @ModelAttribute("product") Product product, 
									BindingResult result) {
		System.out.println("-----Post method Reached------");
		
		if(result.hasErrors()) {
			return "redirect:/createProduct";
		}
		else {
			System.out.println("Product Added");
			System.out.println(product.getProductType());
			
			productService.save(product);
			
			return "productConfirmation";
		}
	}
	
	@RequestMapping(value="/listProduct")
	public String listProducts(Model model) {
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "listProduct";
	}
	
	@RequestMapping(value="/product/{productId}", method=RequestMethod.GET)
	public String get(@PathVariable int productId, Model model) {
		System.out.println("Product ID: "+productId);
		model.addAttribute("product", productService.getProduct(productId));
		return "proudctDetail";
	}
	
	@RequestMapping(value="/product/{productId}", method=RequestMethod.POST)
	public String update(Product product, @PathVariable int productId, Model model) {
		System.out.println(">>>>This is the price "+product.getPrice());
		
		Product p = productService.getProduct(productId);
		p.setProductName(product.getProductName());
		p.setPrice(product.getPrice());
		p.setDescription(product.getDescription());
		p.setProductType(product.getProductType());
		
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		
		return "listProduct";
		
//		carDao.update(id, car); // car.id already set by binding
//		return "redirect:/cars";
	}
	
	@RequestMapping(value="/product/delete", method=RequestMethod.POST)
	public String delete( @RequestParam int productId) {
		//int productId =Integer.parseInt(id);
		System.out.println(">>>>delete>>>>>>");
		Product p = productService.getProduct(productId);
		productService.delete(p);
		
		return "redirect:/listProduct";
	}
	////**********************Person**************************
	@RequestMapping(value="/createPerson")
	public String createPersonGet(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "createPerson";
	}
	
	@RequestMapping(value="/createPerson", method=RequestMethod.POST)
	public String createPersonPOST(@Valid @ModelAttribute("person") Person person, 
									BindingResult result) {
		System.out.println("-----Post method Reached------");
		
		if(result.hasErrors()) {
			return "redirect:/createPerson";
		}
		else {
			/*System.out.println("Person Added");
			System.out.println(product.getProductType());*/
			
			personService.savePerson(person);
			
			return "personConfirmation";
		}
	}
	
}
