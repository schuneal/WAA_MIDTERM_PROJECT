package edu.mum.coffee.restapi;

import edu.mum.coffee.domain.*;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import edu.mum.coffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public List<Product> listProducts() {
        List<Product> products = productService.getAllProduct();
        return products;
    }

    @RequestMapping(value = "/listPersons", method = RequestMethod.GET)
    public List<Person> listPersons(){
        List<Person> persons = personService.getAllPerson();
        return persons;
    }
}





