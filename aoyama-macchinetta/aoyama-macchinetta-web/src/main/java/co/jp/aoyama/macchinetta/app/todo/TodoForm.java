package co.jp.aoyama.macchinetta.app.todo;

import java.io.Serializable;
import java.util.Date;

public class TodoForm implements Serializable {

	private static final long serialVersionUID = -1334455296099108036L;

	private String todoId;

    private String todoTitle;
    

	public String getTodoId() {
		return todoId;
	}

	public String getTodoTitle() {
		return todoTitle;
	}


	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

}
