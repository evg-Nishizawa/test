package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Task;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;

@Controller
public class ListController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Task> taskList = taskRepository.findAllByOrderById();
        model.addAttribute("tasks", taskList);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);

        return "list";
    }

    @PostMapping("/task/search")
    public String search(@RequestParam("categoryId") int categoryId,
                    @RequestParam("taskSort") int taskSort,
                    Model model) {
        // List<Task> sortList = taskRepository.findAll();
        List<Task> sortList = null;
        // if (categoryId != 0 && taskSort == 0) {
        // sortList = taskRepository.findByCategory_categoryId(categoryId);
        //// sortList = taskRepository.catTask(categoryId);
        // } else if (categoryId != 0 && taskSort == 1) {
        // sortList =
        // taskRepository.findByCategory_categoryIdOrderByDateAsc(categoryId);
        // } else if (categoryId != 0 && taskSort == 2) {
        // sortList =
        // taskRepository.findByCategory_categoryIdOrderByImpDesc(categoryId);
        // } else if (categoryId == 0 && taskSort == 1) {
        // sortList = taskRepository.findAllByOrderByDateAsc();
        // } else if (categoryId == 0 && taskSort == 2) {
        // sortList = taskRepository.findAllByOrderByImpDesc();
        // } else {
        // sortList = taskRepository.findAll();
        // }
        if (categoryId != 0) {
            if (taskSort == 1) {
                sortList = taskRepository.findByCategory_categoryIdOrderByDateAsc(categoryId);
            } else if (taskSort == 2) {
                sortList = taskRepository.findByCategory_categoryIdOrderByImpDesc(categoryId);
            } else {
                sortList = taskRepository.findByCategory_categoryId(categoryId);
            }
        } else {
            if (taskSort == 1) {
                sortList = taskRepository.findAllByOrderByDateAsc();
            } else if (taskSort == 2) {
                sortList = taskRepository.findAllByOrderByImpDesc();
            } else {
                sortList = taskRepository.findAll();
            }
        }
        model.addAttribute("tasks", sortList);

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);

        return "list";
    }

    @GetMapping("/add")
    public String post(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);

        return "newTask";
    }

    @PostMapping("/add")
    public String newPost(@RequestParam("name") String name,
                    @RequestParam(value = "date", defaultValue = "") LocalDate date,
                    @RequestParam("category") Integer categoryId,
                    @RequestParam(name = "imp", defaultValue = "0") Integer imp,
                    Model model) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        Task task;
        if (imp == 1) {
            task = new Task(name, date, category, imp);
        } else {
            task = new Task(name, date, category);
        }
        taskRepository.save(task);

        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id,
                    Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        Task editTask = taskRepository.findById(id).get();
        model.addAttribute("editTasks", editTask);
        return "editTask";
    }

    @PostMapping("/edited")
    public String edited(@RequestParam("id") Integer id,
                    @RequestParam("name") String name,
                    @RequestParam(value = "date", defaultValue = "") LocalDate date,
                    @RequestParam("category") Integer categoryId,
                    @RequestParam(name = "imp", defaultValue = "0") Integer imp,
                    Model model) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        Task editedTask = taskRepository.findById(id).get();
        if (imp == 1) {
            editedTask.setTask(name, date, category, imp);
        } else {
            editedTask.setTask(name, date, category);
        }
        taskRepository.save(editedTask);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/comp")
    public String comp(@RequestParam("id") int id,
                    @RequestParam("comp") Integer comp,
                    Model model) {
        Task compTask = taskRepository.findById(id).get();
        if (comp == 0) {
            comp = 1;
        } else {
            comp = 0;
        }
        compTask.setComp(comp);
        taskRepository.save(compTask);

        return "redirect:/";
    }

}
