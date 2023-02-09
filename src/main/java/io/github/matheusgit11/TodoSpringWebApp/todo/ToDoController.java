package io.github.matheusgit11.TodoSpringWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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
        List<Todo> todos = toDoService.findByUsername("matheus");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = (String)model.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusWeeks(2),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo , BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = (String)model.get("name");
        toDoService.addTodo(username,todo.getDescription(), LocalDate.now().plusWeeks(2),false);
        return "redirect:list-todos";
    }

}