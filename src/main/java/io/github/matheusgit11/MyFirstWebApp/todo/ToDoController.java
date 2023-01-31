package io.github.matheusgit11.MyFirstWebApp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<ToDo> todos = toDoService.findByUsername("matheus");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

}
