package com.example.ec.exploreCali.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ec.exploreCali.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{

	//no need to implement it => findBy+fieldName => hibernate do the query automatically
	
	//to use in postman: "http://localhost:8080/tourPackages/search/findByName?tourPackagesName=Backpack Cal"
	TourPackage findByName(@Param("name") String tourPackagesName);

}
