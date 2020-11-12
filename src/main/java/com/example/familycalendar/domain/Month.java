package com.example.familycalendar.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//kuukausi-olio
@Entity
public class Month {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long monthid;
	
	private String name;
	//yhdistetään osaksi tehtävä-oliota/taulua
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "month")
	private List<Task> tasks;
	
	public Month() {}
	
	public Month(String name) {
		super();
		this.name = name;
	}
	
	
	public long getMonthid() {
		return monthid;
	}

	public void setMonthid(long monthid) {
		this.monthid = monthid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Month [monthid=" + monthid + ", name=" + name + "]";
	}
	

}
