package edu.mum.coffee.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.PersonCreator;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import edu.mum.coffee.service.UserService;

@Controller
public class UserController {	
	@Resource
	private PersonService personService;
	@Resource
	private ProductService productService;
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping(value="/placeOrder")
	public String placeOrder(Model productModel,HttpSession session) {
		List<Product> products = new ArrayList<>();
		products = productService.getAllProduct();

		
		List<String> productNames = new ArrayList<>();
		List<String> description = new ArrayList<>();
		for(Product p : products) {
			if(!productNames.contains(p.getProductName())) {
				productNames.add(p.getProductName());
			}
			if(!description.contains(p.getDescription())) {
				description.add(p.getDescription());
			}
		}
		
		productModel.addAttribute("productNames", productNames);
		productModel.addAttribute("description", description);
		
		Person prs = (Person) session.getAttribute("person");

		return "placeOrder";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String saveOrder(@RequestParam("productname") String productname,
			@RequestParam("desciption") String desciption,@RequestParam("quantity") String quantity, HttpSession session) {
		int qty=quantity.charAt(0)-48;
		//get product related to this order
		List<Product> products = productService.getAllProduct();
		Product p = null;
		for(Product prd : products ) {
			if(prd.getProductName().equals(productname) && prd.getDescription().equals(desciption)) {
				p=prd;
				break;
			}
		}
		
		//person who is making this order
        Person prs = (Person) session.getAttribute("person");

        
        //order date
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        
        //create order and orderline objects and set their properties
        Order order = new Order();
        order.setOrderDate(date);
        order.setPerson(prs);
        Orderline orderLine = new Orderline();
        orderLine.setProduct(p);
        orderLine.setQuantity(qty);
        order.addOrderLine(orderLine);
        orderService.save(order);
		return "user-page";
	}
	
	@RequestMapping(value="/updateprofile")
	public String updateProfile(Model model,HttpSession session) {
		 Person prs = (Person) session.getAttribute("person");
		 Address address = prs.getAddress();
		 String email = prs.getEmail();
		 User user = userService.findByUsername(email);
		 String pw = user.getPassword();
		 PersonCreator pc = new PersonCreator();
		 pc.setId(prs.getId());
		 pc.setFirstName(prs.getFirstName());
		 pc.setLastName(prs.getLastName());
		 pc.setPhone(prs.getPhone());
		 pc.setEmail(prs.getEmail());
		 pc.setCity(address.getCity());
		 pc.setState(address.getState());
		 pc.setZipcode(address.getZipcode());
		 pc.setCountry(address.getCountry());
		 pc.setPassword(pw);
		 model.addAttribute("person", pc);
		return "userDetail";
		
	}
	
	@RequestMapping(value="/updateprofile",method=RequestMethod.POST)
	public String updateProfilePost(@ModelAttribute PersonCreator pc, HttpSession session) {

		Person p = personService.findById(pc.getId());
		p.setFirstName(pc.getFirstName());
		p.setLastName(pc.getLastName());
		p.setEmail(pc.getEmail());
		p.setPhone(pc.getPhone());
		System.out.println("Created person: "+p.getFirstName());
		Address address = p.getAddress();
		address.setCity(pc.getCity());
		address.setState(pc.getState());
		address.setCountry(pc.getCountry());
		address.setZipcode(pc.getZipcode());
		p.setAddress(address);
		User user = userService.findByUsername(p.getEmail());
		user.setPassword(pc.getPassword());
		session.setAttribute("person", p);
		return "user-page";
	}

}
