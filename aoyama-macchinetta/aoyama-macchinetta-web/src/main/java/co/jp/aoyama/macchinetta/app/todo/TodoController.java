package co.jp.aoyama.macchinetta.app.todo;

import java.util.Date;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Todo;
import co.jp.aoyama.macchinetta.domain.model.TodoCriteria;
import co.jp.aoyama.macchinetta.domain.service.todo.TodoService;

@Controller
@RequestMapping(value = "/todo")
@TransactionTokenCheck("todo")
public class TodoController {

    @Inject
    SessionContent sessionContent;
    
    @Inject
    TodoService aoyamaService;
    
    private TodoForm todoForm = new TodoForm();
    
    @Inject
    Mapper beanMapper;
    
    private static final Logger logger = LoggerFactory
            .getLogger(TodoController.class);
	
	  @ModelAttribute
	  public TodoForm setupForm() {
	    return todoForm;
	  }

	  @RequestMapping(value = "select/{todoId}", method = RequestMethod.GET)
	  @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
	  public String createForm(@PathVariable("todoId") String todoId, Model model) {
		  try {
			  Todo todo = aoyamaService.findOne(todoId);
			  beanMapper.map(todo, todoForm);
		  } catch (ResourceNotFoundException e) {
			// エラーメッセージ
			model.addAttribute("resultMessages", e.getResultMessages());
			// ログを出力
			logger.error(e.getResultMessages().toString());
			logger.info("This log is info log.");
			logger.warn("This log is warn log.");
		  }
	        
	    return "todo/todoForm"; 
	  }
	  
	  @RequestMapping(value = "confirm", method = RequestMethod.POST)
	  @TransactionTokenCheck(type = TransactionTokenType.IN)
	  public String confirm(@Validated TodoForm form, BindingResult result) { // (5)
	    if (result.hasErrors()) {
	      return "todo/todoForm";
	    }
	    // omitted business logic
	    return "todo/todoConfirm";
	  }
	  
	  @RequestMapping(value = "create", method = RequestMethod.POST, params = "form")
	  @TransactionTokenCheck(type = TransactionTokenType.IN)
	  public String create(@Validated TodoForm form, BindingResult result, Model model) { // (5)
	    if (result.hasErrors()) {
	      return "todo/todoForm";
	    }
	    try {
	    	Todo createdTodo = aoyamaService.create(beanMapper.map(form, Todo.class));

	    } catch (BusinessException e) {

			// エラーメッセージ
	    	model.addAttribute("resultMessages", e.getResultMessages());
	    	// ログを出力
	    	logger.error(e.getResultMessages().toString());
        }
	    // omitted business logic
	    return "redirect:/todo/create?complete";
	  }
	  
	  @RequestMapping(value = "create", method = RequestMethod.GET, params = "complete")
	  public String createComplete() {
	    return "todo/createComplete";
	  }
	  
	    // 更新
	    @RequestMapping(value="update/{todoId}", method = {RequestMethod.POST, RequestMethod.GET})
	    public String putTodo(@Validated TodoForm form, BindingResult result) {
	        Todo finishedTodo = aoyamaService.finish(form.getTodoId());
	        TodoForm finishedTodoForm = beanMapper.map(finishedTodo, TodoForm.class);
	        
	        return "redirect:/todo/create?complete";
	    }
	    // 削除
	    @RequestMapping(value="delete/{todoId}", method = RequestMethod.POST)
	    public String deleteTodo(@PathVariable("todoId") String todoId) {
	    	aoyamaService.delete(todoId);
	    	
	    	return "redirect:/todo/create?complete";
	    }
	    
	  @RequestMapping(value = "initSearch", method = RequestMethod.GET)
	  public String initSearch(SessionStatus sessionStatus) {
		  sessionStatus.setComplete();
		  String a = sessionContent.getAuthority();
	    return "todo/initTodoForm";
	  }
	    
	    @RequestMapping(value = "list", method = RequestMethod.GET)
	    public String list(@Validated TodoForm form,
	            BindingResult result,
	            Pageable pageable,
	            Model model) {

	    	TodoCriteria criteria = beanMapper.map(form,
	    			TodoCriteria.class);

	    	Date createdAt = new Date();
	    	criteria.setCreatedAt(createdAt);
	    	
	        Page<Todo> page = aoyamaService.searchTodos(criteria, pageable);

	        model.addAttribute("page", page);

	        return "todo/searchTodoForm";
	    }
	  
}
