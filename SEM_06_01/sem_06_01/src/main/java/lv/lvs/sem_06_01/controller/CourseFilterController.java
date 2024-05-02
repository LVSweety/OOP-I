package lv.lvs.sem_06_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lv.lvs.sem_06_01.service.ICourseFilterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/api/course/filter")
public class CourseFilterController {

    @Autowired
    private ICourseFilterService courseService;

    @GetMapping("/elc/{param}")
    public String getCourseFilterByCp(@PathVariable("param") int elc, Model model) {
        try {
            model.addAttribute("data", courseService.selectCoursesByElc(elc));
            model.addAttribute("msg", "FILTER BY ELC");
            return "FilterCourse";  
        } catch (Exception e) {
            System.err.println(e);
            return "ERROR";
        }
    }
    
    
}