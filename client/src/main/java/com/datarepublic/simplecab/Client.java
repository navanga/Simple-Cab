package com.datarepublic.simplecab;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Client implements CommandLineRunner {

	@Autowired
    SimpleCabService simpleCabService;
	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
		 System.out.print("\n\nEnter option number: \n\n"
		 		+ "1. Reset Cache \n"
		 		+ "2. Search Medallion Trips \n"
		 		+ "3. Exit \n");
		
		 switch(scanner.next()) {
		 
		 	case "1" :
		 		simpleCabService.deleteCache();
		 		break;
		 	case "2" :
				System.out.print("Enter medallions (comma seperated): ");
				String medallions = scanner.next();
				System.out.print("Enter Pickup date (dd/MM/yyyy): ");
				String pickupDate = scanner.next();
				System.out.print("Ignore Cache (Y/N): ");
				boolean ignoreCache = scanner.next().equalsIgnoreCase("Y")? true: false;
				simpleCabService.getMedallionsSummary(pickupDate, ignoreCache, medallions.split(","));
		 		break;
		 	case "3" :
		 		System.exit(0);
		 	default :
		 		System.out.print("Invalid input");
		 		
		 }
		
		}

	}

}
