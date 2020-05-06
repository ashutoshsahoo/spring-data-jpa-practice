package com.ashu.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ashu.practice.util.BookConstants;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book implements Serializable {

	private static final long serialVersionUID = -7891510884821585699L;

	@Id
	@SequenceGenerator(name = "BOOK_SEQ_GEN", sequenceName = "BOOK_ID_SEQUENCE", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "BOOK_SEQ_GEN")
	private Long id;

	@Column(length = 13, nullable = false, unique = true)
	@NotBlank(message = "isbn should not be empty or null")
	@Size(min = 13, max = 13, message = "isbn should have 13 character length")
	@Pattern(regexp = BookConstants.ISBN_REGEX, message = "Invalid isbn")
	private String isbn;

	@NotBlank(message = "name should not be empty or null")
	@Size(min = 2, max = 30, message = "name should have minimun 2 characters and maximum 30 characters length")
	@Column(length = 30, nullable = false)
	@Pattern(regexp = BookConstants.NAME_REGEX, message = "Invalid name - no special characters allowed")
	private String name;

	@Size(min = 2, max = 30, message = "author should have minimun 2 characters and maximum 30 characters length")
	@Column(length = 30)
	@Pattern(regexp = BookConstants.NAME_REGEX, message = BookConstants.NAME_REGEX_FAILURE_MSG)
	private String author;

}
