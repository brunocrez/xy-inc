package com.docker.xyinc.builder;

import java.util.ArrayList;
import java.util.List;

import com.docker.xyinc.model.Poi;

public class PoiBuilder {
		
	private Poi poi;
	private List<Poi> pois = new ArrayList<Poi>();
	private List<Poi> poisInRange = new ArrayList<Poi>();
	
	public Poi buildPoi() {		
		this.poi = new Poi();
		this.poi = createListPois().get(0);
		return this.poi;
	}
	
	public List<Poi> createListPois() {
		
		this.pois.add(new Poi("Lanchonete", 27, 12));
		this.pois.add(new Poi("Posto", 31, 18));
		this.pois.add(new Poi("Joalheria", 15, 12));
		this.pois.add(new Poi("Floricultura", 19, 21));
		this.pois.add(new Poi("Pub", 12, 8));
		this.pois.add(new Poi("Supermercado", 23, 6));
		this.pois.add(new Poi("Churrascaria", 28, 2));
		
		return this.pois;
	}
	
	public List<Poi> createListPoisInRange() {
		
		List<Poi> pois = createListPois();
		
		/* Seleção de POIs de acordo com o enunciado do problema (x=20, y=10, dMax=10) */
		this.poisInRange.add(pois.get(0)); 
		this.poisInRange.add(pois.get(2)); 
		this.poisInRange.add(pois.get(4)); 
		this.poisInRange.add(pois.get(5)); 
		
		return poisInRange;
	}
}
