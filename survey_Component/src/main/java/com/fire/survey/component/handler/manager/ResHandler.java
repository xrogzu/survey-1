package com.fire.survey.component.handler.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.survey.component.service.i.ResService;
import com.fire.survey.entities.manager.Res;

@Controller
@RequestMapping("/manage/res")
public class ResHandler {
	
	@Autowired
	private ResService resService;
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, String> delete(@RequestParam("resId")Integer resId){
		boolean resultStatus = resService.remove(resId);
		Map<String, String> map = new HashMap<>();
		map.put("resultStatus", resultStatus+"");
		map.put("message", "success");
		return map;
	}
	
	@RequestMapping("/details")
	public String showDetails(HttpServletRequest request){
		List<Res> ress = resService.getResList();
		request.setAttribute("ress", ress);
		return "manage/resource_manage";
	}
	
}
