package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String todoId;

    private String todoTitle;

    private boolean finished;

    private Date createdAt;

    private long version;

	public String getTodoId() {
		return todoId;
	}

	public String getTodoTitle() {
		return todoTitle;
	}

	public boolean isFinished() {
		return finished;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public long getVersion() {
		return version;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
