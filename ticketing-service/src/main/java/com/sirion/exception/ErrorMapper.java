package com.sirion.exception;

import java.util.Date;

public class ErrorMapper {
	private String url;
	private String message;
	private Date date;

	public ErrorMapper() {

	}

	public ErrorMapper(String url, String message, Date date) {
		super();
		this.url = url;
		this.message = message;
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
