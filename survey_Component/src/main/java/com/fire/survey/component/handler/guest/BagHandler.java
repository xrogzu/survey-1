package com.fire.survey.component.handler.guest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fire.survey.component.service.i.BagService;
import com.fire.survey.entities.guest.Bag;

@Controller
@RequestMapping("/bag")
public class BagHandler {

	@Autowired
	private BagService bagService;

	@RequestMapping("/doUpdate")
	public String doUpdate(Bag bag) {
		bagService.update(bag);
		return "redirect:/survey/design/" + bag.getSurvey().getId();
	}

	@RequestMapping("/update/{bagId}/{surveyId}")
	public String update(@PathVariable("bagId") Integer bagId, @PathVariable("surveyId") Integer surveyId,
			Map<String, Object> map) {
		Bag bag = bagService.getBag(bagId);
		map.put("bag", bag);
		return "guest/bag_edit";
	}

	@RequestMapping("/delete/{bagId}/{surveyId}")
	public String delete(@PathVariable("bagId") Integer bagId, @PathVariable("surveyId") Integer surveyId) {
		Bag bag = new Bag();
		bag.setBagId(bagId);
		bagService.deleteBag(bag);
		return "redirect:/survey/design/" + surveyId;
	}

	@RequestMapping("/doDelete/{bagId}/{surveyId}")
	public String doDelete(@PathVariable("bagId") Integer bagId, @PathVariable("surveyId") Integer surveyId) {
		Bag bag = bagService.getBag(bagId);
		bagService.deleteBag(bag);
		return "redirect:/survey/design/" + surveyId;
	}

	@RequestMapping("/doAdd")
	public String doAdd(Bag bag) {
		System.out.println(bag);
		bagService.save(bag);
		return "redirect:/survey/design/" + bag.getSurvey().getId();
	}

	@RequestMapping("/addBag/{id}")
	public String add(@PathVariable("id") Integer id) {
		return "guest/bag_add";
	}

}
