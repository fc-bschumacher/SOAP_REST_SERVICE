package eu.fincon.hellosoap.service.model;

import java.io.Serializable;

public class RestResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
