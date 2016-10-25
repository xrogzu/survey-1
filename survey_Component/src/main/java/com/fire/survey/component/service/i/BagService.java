package com.fire.survey.component.service.i;

import java.util.List;

import com.fire.survey.entities.guest.Bag;

public interface BagService {

	void save(Bag bag);

	void deleteBag(Bag bag);

	Bag getBag(Integer bagId);
	
	void update(Bag bag);

	void batchUpdateOrder(List<Integer> orderIds, List<Integer> orders);
	
}
