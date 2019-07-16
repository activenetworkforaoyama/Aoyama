package co.jp.aoyama.macchinetta.domain.service.todo;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.jp.aoyama.macchinetta.domain.model.Todo;
import co.jp.aoyama.macchinetta.domain.model.TodoCriteria;

public interface TodoService {
	Todo findOne(String todoId);
	
    Collection<Todo> findAll();

    Todo create(Todo todo);

    Todo finish(String todoId);

    void delete(String todoId);
    
    Page<Todo> searchTodos(TodoCriteria criteria, Pageable pageable);
}
