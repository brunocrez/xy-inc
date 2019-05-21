package com.docker.xyinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docker.xyinc.model.Poi;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Integer> {

	@Query(value = "SELECT * FROM pois WHERE ((POWER(x - ?,2) + POWER(y - ?,2)) <= POWER(?,2))", nativeQuery=true)
	List<Poi> getInRange(int x, int y, int dMax);	
}
