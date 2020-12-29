package com.tour.service;

import org.w3c.dom.Element;

import com.tour.dto.TourContentInfoDTO;

public interface TourContentInfoService {
	public String getTagValue(String tag, Element eElement);
	public TourContentInfoDTO getTourContent(String contentid, String contenttypeid) throws Exception;
}
