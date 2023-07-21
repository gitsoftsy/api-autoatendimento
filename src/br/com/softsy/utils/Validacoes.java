package br.com.softsy.utils;

public class Validacoes {
	public static boolean isNullOrEmpty(String texto) {
		if (texto == null || texto.isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isLongNull(Long inteiro) {
		if (inteiro == null)
			return true;
		else
			return false;
	}
	
	public static boolean isLongEmpty(Long inteiro) {
		if (inteiro.toString().isEmpty())
			return true;
		else
			return false;
	}
	
	
}
