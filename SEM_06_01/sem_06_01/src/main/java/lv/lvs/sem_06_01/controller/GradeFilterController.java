package lv.lvs.sem_06_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.lvs.sem_06_01.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
	
	@Autowired
	private IGradeFilterService gradeService;
	
	@GetMapping("/student/{id}")
	public String getGradeFilterStudentById(@PathVariable("id") int id, 
			Model model) {
		
		try
		{
			model.addAttribute("mydata", gradeService.selectGradesByStudentId(id));
			return "grade-all-show-page";
		}catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}

}