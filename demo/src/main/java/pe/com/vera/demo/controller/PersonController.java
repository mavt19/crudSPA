package pe.com.vera.demo.controller;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.vera.demo.entity.Person;
import pe.com.vera.demo.service.AbstractDao;

@Controller
public class PersonController {

	@Autowired
	AbstractDao<Person> _servicePerson;
	
	@RequestMapping(path= {"/","/{id}"})
	public String findAll(Model model,@PathVariable("id") Optional<Long> id)
	{
		Optional<Person> person;
		if(id.isPresent())
		{
			person=_servicePerson.findById(id.get());
			model.addAttribute("person", person);
			model.addAttribute("id1", id);
		}
		else {
			model.addAttribute("person", new Person());
		}
		model.addAttribute("lista", _servicePerson.finAll());
		
		return "inicio";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute Person person)
	{
		if(person.getId()==null) {
	
		 _servicePerson.addOrUpdate(person);
		}else {
			Person persondb = _servicePerson.findById(person.getId()).get();
			persondb.setName(person.getName());
			persondb.setLastName(person.getLastName());
			 _servicePerson.addOrUpdate(persondb);
		}
			

	
		return "redirect:/";
		
	}
	
	/*@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model)
	{
		
		Optional<Person> person= null;
		person=_servicePerson.findById(id);
		model.addAttribute("person", person);
		model.addAttribute("lista", _servicePerson.finAll());
		return "/inicio";
	}*/
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id)
	{
		_servicePerson.remove(id);
		return "redirect:/";
	}
}
