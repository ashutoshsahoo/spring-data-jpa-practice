package com.ashu.practice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ashu.practice.util.BookConstants;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

	private Long id;

	@NotBlank(message = "isbn should not be empty or null")
	@Size(min = 13, max = 13, message = "isbn should have 13 character length")
	@Pattern(regexp = BookConstants.ISBN_REGEX, message = "Invalid isbn")
	private String isbn;

	@NotBlank(message = "name should not be empty or null")
	@Size(min = 2, max = 30, message = "name should have minimun 2 characters and maximum 30 characters length")
	@Pattern(regexp = BookConstants.NAME_REGEX, message = "Invalid name - no special characters or numbers allowed")
	private String name;

	@Size(min = 2, max = 30, message = "author should have minimun 2 characters and maximum 30 characters length")
	@Pattern(regexp = BookConstants.NAME_REGEX, message = BookConstants.NAME_REGEX_FAILURE_MSG)
	private String author;
}
