package lv.lvs.sem_06_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.lvs.sem_06_01.service.ICourseFilterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/api/course/filter")
public class CourseFilterController {

    @Autowired
    private ICourseFilterService courseService;

    @GetMapping("/elc/{param}")
    public String getCourseFilterByElc(@PathVariable("param") int elc, Model model) {
        try {
            model.addAttribute("data", courseService.selectCoursesByElc(elc));
            model.addAttribute("msg", "FILTER BY ELC");
            return "FilterCourse";  
        } catch (Exception e) {
            System.err.println(e);
            return "ERROR";
        }
    }

    @GetMapping("/prof/{param}")
    public String getCourseFilterByProfesorID(@PathVariable("param") int id, Model model) {
        try {
            model.addAttribute("data", courseService.selectCoursesByProfessorId(id));
            model.addAttribute("msg", "FILTER BY PROFESOR");
            return "FilterCourse";  
        } catch (Exception e) {
            System.err.println(e);
            return "ERROR";
        }
    }
    
    @GetMapping("/student/{param}")
    public String getCourseFilterByStudentID(@PathVariable("param") int id, Model model) {
        try {
            model.addAttribute("data", courseService.selectCoursesByStudentId(id));
            model.addAttribute("msg", "FILTER BY STUDENT");
            return "FilterCourse";  
        } catch (Exception e) {
            System.err.println(e);
            return "ERROR";
        }
    }
}