/**
 * 
 */
package com.nagihome.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagihome.sakila.entites.Actor;
import com.nagihome.sakila.service.ActorService;

/**
 * @author nageswararao
 *
 */
@Controller
public class ActorUpdateUIController {

	@Autowired
	private ActorService actorService;

	@RequestMapping(value = "/listActors", method = RequestMethod.GET)
	public String listActors(ModelMap map) {

		map.addAttribute("actor", new Actor());
		map.addAttribute("actorList", actorService.getAllActors());

		return "editActorList";
	}

	@RequestMapping(value = "/addActor", method = RequestMethod.POST)
	public String addActor(@ModelAttribute Actor actor, BindingResult br) {
		actorService.addActor(actor);
		return "redirect:/";
	}

	@RequestMapping("deleteActor/{actorId}")
	public String deleteActor(@PathVariable("actorId") int actorId) {
		actorService.deleteActor(actorId);
		return "redirect:/";
	}

	/**
	 * @return the actorService
	 */
	public ActorService getActorService() {
		return actorService;
	}

	/**
	 * @param actorService
	 *            the actorService to set
	 */
	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}

}
