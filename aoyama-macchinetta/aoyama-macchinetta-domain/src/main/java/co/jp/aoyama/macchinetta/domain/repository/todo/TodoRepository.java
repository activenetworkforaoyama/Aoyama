package co.jp.aoyama.macchinetta.domain.repository.todo;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import co.jp.aoyama.macchinetta.domain.model.Todo;
import co.jp.aoyama.macchinetta.domain.model.TodoCriteria;

public interface TodoRepository {
    Todo findOne(String todoId);

    Collection<Todo> findAll();

    void create(Todo todo);

    boolean update(Todo todo);

    void delete(Todo todo);

    long countByFinished(boolean finished);
    
    long exists(String todoId);
    
    long countByCriteria(@Param("criteria") TodoCriteria criteria);
    
    List<Todo> findPageByCriteria(
    		@Param("criteria") TodoCriteria criteria,
            @Param("pageable") Pageable pageable);
}


