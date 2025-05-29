package com.app.todoApp.controller;
import com.app.todoApp.models.Task;
import com.app.todoApp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController
{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getTasks(Model model) {  // Model added here
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks"; // name of the Thymeleaf file (tasks.html)
    }

    @PostMapping("/")
    public String postTasks(@RequestParam String title) {  // 👈 Model added here
        taskService.postTasks(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {  // 👈 Model added here
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id) {  // 👈 Model added here
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
