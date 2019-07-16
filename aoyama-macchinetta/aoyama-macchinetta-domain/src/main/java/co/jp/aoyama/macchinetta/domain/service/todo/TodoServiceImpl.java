package co.jp.aoyama.macchinetta.domain.service.todo;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;
import co.jp.aoyama.macchinetta.domain.model.Todo;
import co.jp.aoyama.macchinetta.domain.model.TodoCriteria;
import co.jp.aoyama.macchinetta.domain.repository.todo.TodoRepository;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	private static final long MAX_UNFINISHED_COUNT = 100;
	
    private static final Logger logger = LoggerFactory
            .getLogger(TodoServiceImpl.class);
	
	@Inject
    TodoRepository todoRepository;

	@Override
	@Transactional(readOnly = true)
    public Todo findOne(String todoId) {
        Todo todo = todoRepository.findOne(todoId);

        if (todo == null) {
            // (5)
            ResultMessages messages = ResultMessages.error();
            messages.add("E404", todoId);
			logger.error(messages.toString());
			logger.info("This log is info log.");
			logger.warn("This log is warn log.");
            throw new ResourceNotFoundException(messages);
        }
        return todo;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Todo> findAll() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public Todo create(Todo todo) {
		long unfinishedCount = todoRepository.countByFinished(false);
        if (unfinishedCount >= MAX_UNFINISHED_COUNT) {
            ResultMessages messages = ResultMessages.error();
            messages.add("E001", MAX_UNFINISHED_COUNT);
            
            throw new BusinessException(messages);
        }

        String todoId = UUID.randomUUID().toString();
        Date createdAt = new Date();

        todo.setTodoId(todo.getTodoId());
        todo.setCreatedAt(createdAt);
        todo.setFinished(false);

        todoRepository.create(todo);

        return todo;
	}

	@Override
	public Todo finish(String todoId) {
		Todo todo = findOne(todoId);
        if (todo.isFinished()) {
            ResultMessages messages = ResultMessages.error();
            
            messages.add("E002", todoId);
            throw new BusinessException(messages);
        }
        todo.setFinished(true);
        todoRepository.update(todo);
        return todo;
	}

	@Override
	public void delete(String todoId) {
		Todo todo = findOne(todoId);
        todoRepository.delete(todo);

	}

	@Transactional(readOnly = true)
    @Override
    public Page<Todo> searchTodos(TodoCriteria criteria,
            Pageable pageable) {
        long total = todoRepository.countByCriteria(criteria);
        List<Todo> todos;
        if (0 < total) {
            // (5)
            todos = todoRepository.findPageByCriteria(criteria,
                    pageable);
        } else {
            todos = Collections.emptyList();
        }
        return new PageImpl<>(todos, pageable, total);
    }
	
}
