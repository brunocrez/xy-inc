package com.docker.xyinc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docker.xyinc.model.Poi;
import com.docker.xyinc.service.PoiService;

@RestController
@RequestMapping("/poi")
public class PoiController {

	@Autowired
	private PoiService poiService;
	
	@GetMapping("/getAll")
	public List<Poi> findAll() {
		return poiService.findAll();
	}
	
	@GetMapping("/inRange")
	public ResponseEntity<List<Poi>> getInRange(
			@RequestParam(name = "x", required = true) int x,
			@RequestParam(name = "y", required = true) int y,
			@RequestParam(name = "dMax", required = true) int dMax) {
		
		List<Poi> poisInRange = poiService.getInRange(x, y, dMax);
		
		return ResponseEntity.ok(poisInRange);
	}
	
	@PostMapping
	public Poi create(@Valid @RequestBody Poi poi) {
		return poiService.save(poi);
	}
}
