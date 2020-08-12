package com.example.ec.exploreCali.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.ec.exploreCali.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{

	//no need to implement it => findBy+fieldName => hibernate do the query automatically
	TourPackage findByName(String tourPackagesName);

	//List<TourPackage> findOne(String tourPackagesCode);

}
