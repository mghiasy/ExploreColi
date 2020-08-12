package com.example.ec.exploreCali.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ec.exploreCali.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{

	List<TourPackage> findOne(String tourPackagesCode);

}
