package com.example.familycalendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.familycalendar.domain.MonthRepository;
import com.example.familycalendar.domain.Task;
import com.example.familycalendar.domain.TaskRepository;

@Controller
public class CalendarController {
	
	@Autowired
	private TaskRepository trepository;
	
	@Autowired
	private MonthRepository mrepository;
	
	//aloitussivu
	@RequestMapping(value= {"/","/calendar"})
		public String main(Model model) {
		model.addAttribute("tasks", trepository.findAll());
			return "calendar";
	}
	//lisätään tehtävä
	@RequestMapping(value="/add")
		public String add(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("months", mrepository.findAll());
		return "addtask";
	}
	//tehtävän tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Task task){
	    	trepository.save(task);
	        return "redirect:calendar";
	    }    
	//poistetaan tehtävä
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long id, Model model) {
	  trepository.deleteById(id);
	        return "redirect:../calendar";
	    } 
	//muokataan tehtävää
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editTask(@PathVariable("id") Long id, Model model) {
		model.addAttribute("task", trepository.findById(id));
		model.addAttribute("months", mrepository.findAll());
		return "edittask";
	}

}
