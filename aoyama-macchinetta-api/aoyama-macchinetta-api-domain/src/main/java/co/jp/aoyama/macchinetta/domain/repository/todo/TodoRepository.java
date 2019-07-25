package co.jp.aoyama.macchinetta.domain.repository.todo;

import java.util.Collection;

import co.jp.aoyama.macchinetta.domain.model.Todo;

public interface TodoRepository {
    Todo findOne(String todoId);

    Collection<Todo> findAll();

    void create(Todo todo);

    boolean update(Todo todo);

    void delete(Todo todo);

    long countByFinished(boolean finished);
    
    long exists(String todoId);
    
}


