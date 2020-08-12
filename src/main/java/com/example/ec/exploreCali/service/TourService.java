package com.example.ec.exploreCali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.exploreCali.domain.Difficulty;
import com.example.ec.exploreCali.domain.Region;
import com.example.ec.exploreCali.domain.Tour;
import com.example.ec.exploreCali.domain.TourPackage;
import com.example.ec.exploreCali.repository.TourPackageRepository;
import com.example.ec.exploreCali.repository.TourRepository;

@Service
public class TourService {
	public TourRepository tourRepository;
	public TourPackageRepository tourPackageRepository;
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		super();
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public Tour createTour(String title, String desc,String blurb,int price,String duration,
							String bullets,String keywords,Region region,Difficulty diffuculty,String tourPackagesCode ) {
		List<TourPackage> tourPackage = tourPackageRepository.findOne(tourPackagesCode);
		if(tourPackage == null) {
			throw new RuntimeException("Tour package code does not exist "+tourPackagesCode);
		}
		else {
			
			Tour tour=new Tour(title,desc,blurb,price,duration,bullets,keywords,region,diffuculty,tourPackage.get(0));
			return tourRepository.save(tour);
		}
	}
	public Iterable<Tour> lookup(){
		return tourRepository.findAll();
	}
	public long total() {
		return tourRepository.count();
	}
	
}
