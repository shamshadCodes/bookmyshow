package com.shamshad.bookmyshow;

import com.shamshad.bookmyshow.utility.DummyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
    Scanner s = new Scanner(System.in);
    @Autowired
    DummyData data;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************-----------------**************");

        data.addDummyData();

        System.out.println("**************-----------------**************");

//        Map<String, String> optionsMap = new HashMap<>();
//        optionsMap.put("1", "Add City");
//        optionsMap.put("2", "Add Theatre");
//        optionsMap.put("3", "Add Auditorium");
//        optionsMap.put("4", "Add Seat");
//        optionsMap.put("5", "Add Show");
//        optionsMap.put("6", "Add User");
//
//        boolean flag = true;
//
//        do{
//            int count = 0;
//            System.out.println("""
//
//
//                Please select an option from below:\s
//                """);
//
//            for(Map.Entry<String, String> entry : optionsMap.entrySet()){
//                System.out.printf(
//                        "%s%s-> %-18s",
//                        count % 3 == 0 ? "\n" : "",
//                        entry.getKey(),
//                        entry.getValue());
//                count++;
//            }
//            System.out.println("\nPress any other key to exit!");
//
//            String option = s.next();
//            if(optionsMap.containsKey(option))
//                System.out.println("You have chosen: " + optionsMap.get(option));
//            else {
//                System.out.println("Exiting now....");
//                flag = false;
//            }
//        } while(flag);
    }
}
