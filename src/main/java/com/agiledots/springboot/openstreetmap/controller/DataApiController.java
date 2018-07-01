package com.agiledots.springboot.openstreetmap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agiledots.springboot.openstreetmap.entity.Location;

@RestController
@RequestMapping("/map")
public class DataApiController {

	@RequestMapping("/marker")
	public List<Location> marker() {
		List<Location> locations = new ArrayList<Location>();
		for (int i = 1; i <= 100; i++) {
			Location location = new Location();
			location.setId("R" + i);
			// 35.6536122, 139.704882
			location.setLongitude(this.randomDouble(137, 140));
			location.setLatitude(this.randomDouble(34, 36));

			locations.add(location);
		}
		
		Location location = new Location();
		location.setId("R001");
		location.setLongitude(139.794882);
		location.setLatitude(35.6536122);
		locations.add(location);

		return locations;
	}

	/**
	 * 
	 */
	private double randomDouble(double rangeMin, double rangeMax) {
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return randomValue;
	}

}
