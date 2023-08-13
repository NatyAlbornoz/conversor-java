package conversores;


public class ConversorTemperatura {

	public static double convertirTemperatura(String unidadOrigen, String unidadDestino, double cantidad) {
		double resultado = 0.0;

		// Conversiones de temperatura
		if (unidadOrigen.equals("°C")) {
			if (unidadDestino.equals("°F")) {
				resultado = (cantidad * 9 / 5) + 32;
			} else if (unidadDestino.equals("K")) {
				resultado = cantidad + 273.15;
			}
		} else if (unidadOrigen.equals("°F")) {
			if (unidadDestino.equals("°C")) {
				resultado = (cantidad - 32) * 5 / 9;
			} else if (unidadDestino.equals("K")) {
				resultado = (cantidad + 459.67) * 5 / 9;
			}
		} else if (unidadOrigen.equals("K")) {
			if (unidadDestino.equals("°C")) {
				resultado = cantidad - 273.15;
			} else if (unidadDestino.equals("°F")) {
				resultado = (cantidad * 9 / 5) - 459.67;
			}
		}

		return resultado;
	}

}
