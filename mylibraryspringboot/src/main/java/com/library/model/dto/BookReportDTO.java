package com.library.model.dto;

import java.time.LocalDate;

public class BookReportDTO {
	private int id;
	private String name;
	private LocalDate publishDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", publishDate=" + publishDate + "\n";
	}

}
