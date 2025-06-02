package com.app.todoApp.controller;

import com.app.todoApp.models.Task;
import com.app.todoApp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/")
    public String postTasks(@RequestParam String title) {
        taskService.postTasks(title);
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    // Changed PUT to POST for update
    @PostMapping("/{id}/update")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task t1) {
        taskService.updateTask(id, t1);
        return "redirect:/";
    }
}
