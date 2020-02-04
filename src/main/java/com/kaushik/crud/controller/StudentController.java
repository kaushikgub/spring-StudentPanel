package com.kaushik.crud.controller;

import com.kaushik.crud.entity.Student;
import com.kaushik.crud.service.StudentService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudent());
        return "index";
    }

    @GetMapping("/add")
    public String loadSave() {
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid Student student) {
        service.saveOrUpdate(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = service.findStudent(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @GetMapping("delete/{id}")
    public String deleteStudentData(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
