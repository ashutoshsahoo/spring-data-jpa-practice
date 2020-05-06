package com.ashu.practice.util;

public class BookConstants {

	public static final String ISBN_REGEX = "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$";

	public static final String NAME_REGEX = "^[a-zA-Z\\s]+";

	public static final String NAME_REGEX_FAILURE_MSG = "Invalid author - no special characters allowed";
}
