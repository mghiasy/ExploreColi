package com.example.ec.exploreCali.service;

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
							String bullets,String keywords,Region region,Difficulty diffuculty,String tourPackagesName ) {
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackagesName);
		if(tourPackage == null) {
			throw new RuntimeException("Tour package code does not exist "+tourPackagesName);
		}
		else {
			//optionalType => tourpackage.get
			
			Tour tour=new Tour(title,desc,blurb,price,duration,bullets,keywords,region,diffuculty,tourPackage);
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
