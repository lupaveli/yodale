package com.yoda.yodale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class YodaleApplication {
	//sikulix instalacija se nalazi u root folderu

	public static void main(String[] args) {
		SpringApplication.run(YodaleApplication.class, args);

		PostTo postTo = new PostTo();

		postTo.prepareForPost(postTo);


	}

}
