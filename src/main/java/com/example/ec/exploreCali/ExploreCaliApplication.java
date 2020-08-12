package com.example.ec.exploreCali;

import java.io.IOException;
import java.util.List;
import com.example.ec.exploreCali.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ec.exploreCali.service.TourPackageService;
import com.example.ec.exploreCali.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		TourFromFile.importTours().forEach(t->tourService.createTour(t.title,t.description,t.blurb,Integer.parseInt(t.price),
				t.length,t.bullets,t.keywords,Region.findByLabel(t.region),Difficulty.valueOf(t.difficulty),t.packageType));
		System.out.println("Number of tours :"+ tourService.total());
		
	}
	static class TourFromFile{
		private String packageType,title,description,blurb,
				price,length,bullets, keywords, difficulty,region;
		
		static List<TourFromFile> importTours() throws IOException{
			//open the file
			//import all records as a TourFormFile obj
			//return the obj as a list
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD,JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"), 
							new TypeReference<List<TourFromFile>>() {});
			
		}
		
	}


}
