package co.jp.aoyama.macchinetta.domain.service.todo;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Todo;
import co.jp.aoyama.macchinetta.domain.repository.todo.TodoRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class TodoServiceImpl implements TodoService {

	private static final long MAX_UNFINISHED_COUNT = 100;
	
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

	
}
