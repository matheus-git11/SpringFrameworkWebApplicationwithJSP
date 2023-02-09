package io.github.matheusgit11.TodoSpringWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static{
        todos.add(new Todo(++todosCount,
                "matheus",
                "Estudar spring",
                LocalDate.now().plusWeeks(3),
                false));

        todos.add(new Todo(++todosCount,
                "matheus",
                "Estudar Python",
                LocalDate.now().plusMonths(2),
                false));

        todos.add(new Todo(++todosCount,
                "matheus",
                "Estudar Security",
                LocalDate.now().plusWeeks(4),
                false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username , String description , LocalDate targetDate, boolean isDone){
        Todo toDo = new Todo(++todosCount,username,description,targetDate,isDone);
        todos.add(toDo);
    }
}
