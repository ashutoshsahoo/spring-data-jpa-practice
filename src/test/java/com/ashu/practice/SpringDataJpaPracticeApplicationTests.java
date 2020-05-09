package com.ashu.practice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashu.practice.controller.BookController;

@SpringBootTest
class SpringDataJpaPracticeApplicationTests {

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
	}

}
