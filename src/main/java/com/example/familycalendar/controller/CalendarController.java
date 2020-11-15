package com.example.familycalendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		//Järjestetään taskrepositoryn sort-metodilla task-iteraatiot
		model.addAttribute("tasks", trepository.findAll(Sort.by("month").and(Sort.by("date").and(Sort.by("hour").and(Sort.by("minute"))))));
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
	
	
	//REST API-mappaukset
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public @ResponseBody List<Task> taskListRest() {
		return (List<Task>) trepository.findAll();
	}
	
	@RequestMapping (value = "/task/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id")Long id) {
		return trepository.findById(id);
	}

}
