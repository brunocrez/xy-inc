package com.docker.xyinc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.xyinc.model.Poi;
import com.docker.xyinc.repository.PoiRepository;

@Service
public class PoiService {

	@Autowired
	private PoiRepository poiRepository;
	
	public List<Poi> findAll() {
		return poiRepository.findAll();
	}
	
	public List<Poi> getInRange(int x, int y, int dMax) {
		return poiRepository.getInRange(x, y, dMax);
	}
	
	public Poi save(Poi poi) {
		return poiRepository.save(poi);
	}
}
