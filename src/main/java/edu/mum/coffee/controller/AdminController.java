package edu.mum.coffee.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.PersonCreator;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import edu.mum.coffee.service.UserService; 

@Controller
public class AdminController {
	@Resource
	private PersonService personService;
	@Resource
	private ProductService productService;
	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	
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
		PersonCreator personCreator = new PersonCreator();
		model.addAttribute("personCreator", personCreator);
		return "createPerson";
	}
	
	@RequestMapping(value="/personConfirmation")
	public String createPersonGet(@ModelAttribute("person") Person person ) {
		return "personConfirmation";
	}
	
	@RequestMapping(value="/createPerson", method=RequestMethod.POST)
	public String createPersonPOST(@Valid @ModelAttribute("personCreator") PersonCreator personCreator, 							   
								   BindingResult result, RedirectAttributes ra) {
		//Person check = personService.findByEmail(personCreator.getEmail()).get(0);
		
		//if(check==null) {
		Address address = new Address();
		address.setCity(personCreator.getCity());
		address.setState(personCreator.getState());
		address.setCountry(personCreator.getCountry());
		address.setZipcode(personCreator.getZipcode());
				
		
		Person person = new Person();
		person.setFirstName(personCreator.getFirstName());
		person.setLastName(personCreator.getLastName());
		person.setEmail(personCreator.getEmail());
		person.setPhone(personCreator.getPhone()); 
		person.setAddress(address);
		
		
		User user = new User();
		user.setUsername(personCreator.getUsername());
		user.setPassword(personCreator.getPassword());
		user.setRole(personCreator.getRole());
		
		userService.saveUser(user);
		
		ra.addFlashAttribute("person", person);
		
		if(result.hasErrors()) {
			return "redirect:/createPerson";
		}
		else {
			System.out.println("Person Added");	
			personService.savePerson(person);			
			return "redirect:/personConfirmation";
		}
		//}
		//return "redirect:/createPerson";
	}
	
	@RequestMapping(value="/listPerson")
	public String listPersonGet(Model model) {

		List<Person> persons = personService.getAllPerson();
		model.addAttribute("persons", persons);
		return "listPerson";
	}

	@RequestMapping(value="/person/{personId}", method=RequestMethod.GET)
	public String get(@PathVariable long personId, Model model) {
		System.out.println(">>Update Controller -> Person ID: "+personId);
		
		System.out.println("Before findByID");
		Person person = personService.findById(personId);
		System.out.println("After findByID -- Email: "+person.getEmail());
		
		Address address = person.getAddress();
		//System.out.println("After findByID -- Adrees: "+address.getCity());
		
		System.out.println("Before Fetching user: ");
		User user = userService.findByUsername(person.getEmail());
		System.out.println("After Fetching user: ");
		System.out.println("User Name: "+user.getUsername());
		
		PersonCreator pc = new PersonCreator();
		pc.setId(person.getId());
		pc.setFirstName(person.getFirstName());
		pc.setLastName(person.getLastName());
		pc.setPhone(person.getPhone());
		pc.setEmail(person.getEmail());
		pc.setCity(address.getCity());
		pc.setState(address.getState());
		pc.setCountry(address.getCountry());
		pc.setZipcode(address.getZipcode());
		pc.setPassword(user.getPassword());
		
		model.addAttribute("person", pc);
		System.out.println("Returned personDetail");
		return "personDetail";
	}
	
	@RequestMapping(value="/personUpdate", method=RequestMethod.POST)
	public String update(@ModelAttribute PersonCreator pc, Model model) {
			
		System.out.println("Inside Update POST");
		Person p = personService.findById(pc.getId());
		p.setFirstName(pc.getFirstName());
		p.setLastName(pc.getLastName());
		p.setEmail(pc.getEmail());
		p.setPhone(pc.getPhone());
		
		System.out.println("Created person: "+p.getFirstName());
		
		User user = userService.findByUsername(p.getEmail());
		user.setPassword(pc.getPassword());
		
		System.out.println("Set Password: "+user.getPassword());
		
		Address address = p.getAddress();
		address.setCity(pc.getCity());
		address.setState(pc.getState());
		address.setCountry(pc.getCountry());
		address.setZipcode(pc.getZipcode());
		
		p.setAddress(address);		
		System.out.println("Finally Added Addres"+p.getAddress().getCity());

		List<Person> persons = personService.getAllPerson();
		model.addAttribute("persons", persons);
		return "listPerson";
	}	
	
	// Order 
	@RequestMapping(value="/listOrder")
	public String listOrder(Model model) {
		List<edu.mum.coffee.domain.Order> orders;
		orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "listOrder";
	}
}
