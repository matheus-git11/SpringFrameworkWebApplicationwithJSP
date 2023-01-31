package io.github.matheusgit11.MyFirstWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();

    static{
        todos.add(new ToDo(1,
                "matheus",
                "Estudar spring",
                LocalDate.now().plusWeeks(3),
                false));

        todos.add(new ToDo(2,
                "matheus",
                "Estudar Python",
                LocalDate.now().plusMonths(2),
                false));

        todos.add(new ToDo(3,
                "matheus",
                "Estudar Security",
                LocalDate.now().plusWeeks(4),
                false));
    }

    public List<ToDo> findByUsername(String username) {
        return todos;
    }
}
