package com.yoda.yodale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YodaleApplication {


	public static void main(String[] args) {
		SpringApplication.run(YodaleApplication.class, args);



		InstaPost instaPost = new InstaPost();
		System.out.println("Program Arguments:");
		for (String arg : args) {
			instaPost.setPathToFile(arg);
			System.out.println("\t" + arg);
		}
		instaPost.prepareForPost(instaPost);


	}

}
