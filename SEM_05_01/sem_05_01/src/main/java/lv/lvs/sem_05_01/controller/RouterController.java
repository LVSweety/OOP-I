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
public class RouterController {

	@Autowired
	private ICRUDProductService crudService;

	@Autowired
	private IFilterProductService filterService;

	@GetMapping("/hello") // localhost:8080/hello
	public String getHello() {
		System.out.println("First Controller!!!");
		return "hello-page"; // tiek parādīta hello-page.html lapa

	}

	@GetMapping("/hello/msg") // localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		System.out.println("Msg controller is called");
		model.addAttribute("mydata", "Ziņa no JAVA Spring!!!!");
		return "hello-msg-page";// tiek parādīta hello-msg-page.html lapa
	}
	
	@GetMapping("/error")//localhost:8080/error
	public String getError() {
		return "error-page";
	}

}