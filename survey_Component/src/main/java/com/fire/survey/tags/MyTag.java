package com.fire.survey.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		try {
			List<String> subMap = map.get(id);
			if (!input) {
				Boolean check = subMap.contains(option);
				if (check) {
					getJspContext().getOut().write("checked='checked'");
				}
			} else {
				getJspContext().getOut().write(subMap.get(0));
			}
		} catch (Exception e) {
		}
	}

	private String option;
	private String id;
	private Map<String, List<String>> map;
	private boolean input = false;

	public void setInput(boolean input) {
		this.input = input;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

}
