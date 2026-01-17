package com.spring.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	
	@Autowired
	ProductService service;
	
	@RequestMapping("/show")
	public String show(Model model) {
		
		List<Product> list = service.displayProduct();
		for(Product product : list) {
			System.out.println(product.getName()+ " " + product.getCost());
		}
		model.addAttribute("data", list);
		return "index";
	}
}
