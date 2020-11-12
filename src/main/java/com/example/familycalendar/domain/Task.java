package com.example.familycalendar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
//tehtävä-olio
@Entity
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int date;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="monthid")
	private Month month;
	private int hour;
	private int minute;
	private String description;
	
	public Task() {
	}

	public Task(int date, Month month, int hour, int minute, String description) {
		super();
		this.date = date;
		this.month = month;
		this.hour = hour;
		this.minute = minute;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		if(this.month != null)
		return "Task [id=" + id + ", date=" + date + ", month=" + this.getMonth() + ", hour=" + hour + ", minute=" + minute
				+ ", description=" + description + "]";
		else
		return "Task [id=" + id + ", date=" + date + ", hour=" + hour + ", minute=" + minute
				+ ", description=" + description + "]";
	}
	
	
	
	
}
