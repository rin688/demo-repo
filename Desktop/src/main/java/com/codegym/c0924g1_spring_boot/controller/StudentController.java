package com.codegym.c0924g1_spring_boot.controller;

import com.codegym.c0924g1_spring_boot.model.AppUser;
import com.codegym.c0924g1_spring_boot.model.Student;
import com.codegym.c0924g1_spring_boot.service.IClassroomService;
import com.codegym.c0924g1_spring_boot.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;

    @GetMapping("")
    public ModelAndView viewAllStudent(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "name", defaultValue = "")String name) {

        return new ModelAndView("student/list", "students", studentService.findAll(page,2));
    }

    @GetMapping("/create")
    public String viewAddStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", classroomService.getAll());
        return "student/add";
    }

    @PostMapping("/create")
    public String addStudent(@Validated @ModelAttribute("student")Student student,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        String username = SecurityContextHolder. getContext(). getAuthentication().getName();
        System.out.println(username);
        if (bindingResult.hasErrors()) {
             model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("classrooms", classroomService.getAll());
            return "student/add";
        }
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student successfully!");
        return "redirect:/student";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable(name = "id") int id,
                                RedirectAttributes redirectAttributes) {
        studentService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete student successfully");
        return "redirect:/student";
    }
}
