package es.altair.hibernate.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

	private static String sdato;

	/**
	 * Esto es un método que devuelve el dato introducido por el usuario
	 * 
	 * @return Dato default
	 * @exception IOException
	 */

	public static String dato() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		try {
			sdato = flujoE.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sdato;
	}

	public static short datoShort() {
		try {
			return Short.parseShort(dato());
		} catch (NumberFormatException e) {
			return Short.MIN_VALUE;
		}
	}

	public static int datoInt() {
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}

	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch (NumberFormatException e) {
			return Long.MIN_VALUE;
		}
	}

	public static float datoFloat() {
		try {
			return Float.parseFloat(dato());
		} catch (NumberFormatException e) {
			return Float.NaN;
		}
	}

	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
}