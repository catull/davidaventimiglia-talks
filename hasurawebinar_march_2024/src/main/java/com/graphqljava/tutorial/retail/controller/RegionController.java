/** Generated by the default template from graphql-java-generator */
package com.graphqljava.tutorial.retail.controller;

import com.graphqljava.tutorial.retail.model.Region;
import com.graphqljava.tutorial.retail.service.RegionService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RegionController {

	private final RegionService regionService;

    public RegionController(final RegionService regionService) {
        this.regionService = regionService;
    }

	@QueryMapping(name = "allRegions")
	public List<Region> getAllRegions() {
		return this.regionService.getAllRegions();
	}

}
