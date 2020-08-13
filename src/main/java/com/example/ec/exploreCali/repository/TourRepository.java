package com.example.ec.exploreCali.repository;

//import java.awt.print.Pageable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.ec.exploreCali.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour,Integer>{
	
	//for call in postman :"http://localhost:8080/tours?size=3&page=1&sort=title,asc"
	 Page<Tour> findByTourPackageCode(@Param("code") String code,Pageable pageable);

	@Override
	@RestResource(exported = false)
	default <S extends Tour> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported = false)
	default <S extends Tour> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void delete(Tour entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll(Iterable<? extends Tour> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	 
}
