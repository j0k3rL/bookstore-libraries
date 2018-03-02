package com.bookstore.libraries.validation;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.annotation.CPF;

public class CpfValidator implements ConstraintValidator<CPF, String> {

	private Pattern pattern = Pattern.compile(BookstoreConstants.CPF_PATTERN);

	public void initialize(CPF constraintAnnotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validateCPF(value);
	}

	private boolean validateCPF(String value) {

		String cpf = value.replaceAll(BookstoreConstants.ONLY_NUMBERS_PATTERN, BookstoreConstants.EMPTY);
		Matcher m = pattern.matcher(cpf);
		
		if (!m.matches()) {
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;
		
		try {
			
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return false;
		}
	}
}