package br.com.softsy.utils;

public class Validacoes {
	public static boolean isNullOrEmpty(String texto) {
		if (texto == null || texto.isEmpty())
			return true;
		else
			return false;
	}
}
