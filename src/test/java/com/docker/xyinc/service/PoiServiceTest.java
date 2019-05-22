package com.docker.xyinc.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.docker.xyinc.XyIncApplicationTests;
import com.docker.xyinc.builder.PoiBuilder;
import com.docker.xyinc.model.Poi;
import com.docker.xyinc.repository.PoiRepository;

public class PoiServiceTest extends XyIncApplicationTests {

	@Mock
	private PoiRepository poiRepository;
	
	@InjectMocks
	private PoiService poiService;
	
	@Test
	public void findAllTest() {
		List<Poi> pois = new PoiBuilder().createListPois();		
		Assert.assertNotNull(pois);
	}
	
	@Test
	public void getInRangeTest() {
		List<Poi> pois = new PoiBuilder().createListPoisInRange();
		Mockito.when(poiService.getInRange(20, 10, 10)).thenReturn(pois);
		List<Poi> poisByProximity = poiService.getInRange(20, 10, 10);
		
		Assert.assertEquals(pois.get(0), poisByProximity.get(0));
		Assert.assertEquals(pois.get(1), poisByProximity.get(1));
		Assert.assertEquals(pois.get(2), poisByProximity.get(2));
		Assert.assertEquals(pois.get(3), poisByProximity.get(3));
	}
	
	@Test
	public void saveTest() {
		Poi poi = new PoiBuilder().buildPoi();
		Mockito.when(poiService.save(poi)).thenReturn(poi);
		poiService.save(poi);
		Assert.assertNotNull(poi);
	}
}
