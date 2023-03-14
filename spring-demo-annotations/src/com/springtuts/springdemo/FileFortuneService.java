package com.springtuts.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "D:/Spring Udemy Workspace/spring-demo-annotations/src/fortunes.txt";
	private List<String> fortunes;
	
	private Random myRandom = new Random();
	
	@PostConstruct
	public void loadTheFortunesFile() {
		System.out.println(">> FileFortuneService: inside loadTheFortunesFile() method");
		File file = new File(fileName);

		System.out.println("Reading fortunes from File: " + file);
		System.out.println("File exists: " + file.exists());

		fortunes = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String tempLine = null;
			while ((tempLine = br.readLine()) != null) {
				fortunes.add(tempLine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.size());
		String fortune = fortunes.get(index);

		return fortune;
	}

}
