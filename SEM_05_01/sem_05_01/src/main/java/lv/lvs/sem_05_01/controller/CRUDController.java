package lv.lvs.sem_05_01.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.lvs.sem_05_01.model.Product;
import lv.lvs.sem_05_01.service.ICRUDProductService;
import lv.lvs.sem_05_01.service.IFilterProductService;

@Controller
public class CRUDController {
    @Autowired
	private ICRUDProductService crudService;

	@Autowired
	private IFilterProductService filterService;

    @GetMapping("/product/insert") //localhost:8080/product/insert
	public String getProductInsert(Model model) {
		model.addAttribute("product", new Product());//noklusējuma produkts tiks padots uz lapu
		return "product-insert-page";//tiek parādīta product-insert-page.html lapa
	}
	
	//TODO izveidosim html lapu
	
	@PostMapping("/product/insert")
	public String postProductInsert(@Valid Product product, BindingResult result) {//iegūstam aju aizpildītu produktu
		//sajā gadījumā ir validāciju pāŗkāpumi Product objektam
		if(result.hasErrors()) {
			return "product-insert-page";//paliekam šajā pašā lapā
		}
		else
		{
			try {
				crudService.create(product.getTitle(), product.getDescription(), 
					product.getPrice(), product.getQuantity());
				return "redirect:/product/all";//tiks pārvirzīts jeb izsaukts localhost:8080/product/all
			} catch (Exception e) {
			
				return "redirect:/error";//tiks pārvirzīts jeb izsaukt loclahost:8080/error
			}
		}
	
	}

    @GetMapping("/product/update")//localhost:8080/product/update?id=2
	public String getProductUpdateById(@RequestParam("id") int id, Model model) {
		
		try {
			Product updatedProduct = crudService.retrieveById(id);
			model.addAttribute("product", updatedProduct);
			model.addAttribute("id", id);
			return "product-update-page";//tiks parādīta product-update-page.html lapa ar atrasto produktu
			
			
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
	}
	
	
	
	@PostMapping("/product/update")
	public String postProductUpdateById(@Valid Product product, 
			BindingResult result, @RequestParam("id") int id, Model model) {
		
	if(result.hasErrors()) {
		model.addAttribute("id", id);
		return "product-update-page";//tiks parādīta product-update-page.html lapa ar atrasto produktu	
	}
	else
	{
		try
		{
			crudService.updateById(id,product.getTitle(), product.getDescription(), 
				product.getPrice(), product.getQuantity());
			return "redirect:/product/all"; //var arī "redirect:/product/all/" + id; vai arī "redirect:/product/one?id=" + id;
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
	}
		
		
	}
	
	
	@GetMapping("/product/delete/{id}")//localhost:8080/product/delete/2
	public String getProductDeleteById(@PathVariable("id") int id, Model model) {
		
		try {
			crudService.deleteById(id);
			model.addAttribute("mydata", crudService.retrieveAll());
			model.addAttribute("msg", "All products");
			return "product-all-show-page";// tiek parādīta product-all-show-page.html lapa
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
		
	}
    
}