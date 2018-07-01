package com.agiledots.springboot.openstreetmap.entity;

import lombok.Data;

@Data
public class Location {
	String id;
	double latitude;
	double longitude;
}
