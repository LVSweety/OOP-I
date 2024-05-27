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
	public String getGradeFilterStudentById(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("mydata", gradeService.selectGradesByStudentId(id));
			model.addAttribute("msg", "FILTER BY STUDENT");
			return "FilterGradeALL";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "ERROR";
		}
	}

	@GetMapping("/student/fail/{id}")
    public String getGradeFilterFailedByStudentId(@PathVariable("id") int id, Model model){
        try {
            model.addAttribute("mydata", gradeService.selectFailedGradesByStudentId(id));
            model.addAttribute("msg", "FILTER FAILED BY STUDENT");
            return "FilterGradeALL";
        } catch (Exception e) {
            model.addAttribute("errormsg", e.getMessage());
            return "ERROR";
        }
    }

	@GetMapping("/student/average/{id}")
    public String getAVGGradeInCourseById(@PathVariable("id") int id, Model model){
        try {
            float grade = gradeService.calculateAVGGradeInCourseById(id);
            model.addAttribute("mydata", grade);
            model.addAttribute("msg", "AVERAGE GRADE OF STUDENTS IN COURSE");
            return "FilterGradeAVG";
        } catch (Exception e) {
            model.addAttribute("errormsg", e.getMessage());
            return "ERROR";
        }
    }

}




























































































































//te bija alekss