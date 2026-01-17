package com.spring.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	
	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String show(Model model) {
		
		List<Product> list = service.displayProduct();
		for(Product product : list) {
			System.out.println(product.getName()+ " " + product.getCost());
		}
		model.addAttribute("data", list);
		return "index";
	}
	@RequestMapping("/new")
	public String addNewData(Model model) {
		Product product = new Product();  // model class is product class
		model.addAttribute("product", product);
		return "new_Product";
	}
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addData(@ModelAttribute("product")Product product) {
		service.save(product);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id") int id) {
		ModelAndView view = new ModelAndView("edit_product");
		Product product = service.get(id);
		view.addObject("product", product);
		return view;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProductPage(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
