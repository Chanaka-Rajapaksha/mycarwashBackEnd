package com.mcw.mycarwash;

import com.mcw.mycarwash.Service.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MycarwashApplication implements CommandLineRunner {

	@Resource
	FileService storageService;

	public static void main(String[] args) {

		SpringApplication.run(MycarwashApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.init();
	}
}
