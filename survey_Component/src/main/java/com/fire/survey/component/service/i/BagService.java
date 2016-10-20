package com.fire.survey.component.service.i;

import com.fire.survey.entities.guest.Bag;

public interface BagService {

	void save(Bag bag);

	void deleteBag(Bag bag);

	Bag getBag(Integer bagId);
	
	void update(Bag bag);
	
}
