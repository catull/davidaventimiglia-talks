package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.model.Region;
import com.graphqljava.tutorial.retail.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(final RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return this.regionRepository.findAll();
    }

}
