package com.example.ec.exploreCali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ec.exploreCali.service.TourPackageService;
import com.example.ec.exploreCali.service.TourService;

@SpringBootApplication
//main is static and class scope,is not obj scope => does not have access to services => to solve it implements Runner
public class ExploreCaliApplication implements CommandLineRunner{

	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;
	public static void main(String[] args) {
		SpringApplication.run(ExploreCaliApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// is object scope
		//insert data for in-memory database
		//Create the default tour packages
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
		tourPackageService.lookup().forEach(tourPackage->System.out.println(tourPackage));
		
	}

}
