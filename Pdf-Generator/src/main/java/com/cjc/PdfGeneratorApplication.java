package com.cjc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * @SpringBootApplication public class PdfGeneratorApplication {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(PdfGeneratorApplication.class, args); }
 * 
 * }
 */

import com.cjc.dao.CustomerRepository;
import com.cjc.model.Customer;



@SpringBootApplication
public class PdfGeneratorApplication  implements CommandLineRunner{

 @Autowired
 CustomerRepository repository;
 
 public static void main(String[] args) {
   SpringApplication.run(PdfGeneratorApplication.class, args);
 }

   @Override
   public void run(String... args) throws Exception {
     
     if(repository.count() == 0) {
       // save a list of Customers
       repository.saveAll(Arrays.asList(new Customer("Jack", "Smith"), 
                       new Customer("Adam", "Johnson"), 
                       new Customer("Kim", "Smith"),
                       new Customer("David", "Williams"), 
                       new Customer("Peter", "Davis")));
     }

   }
}
