package conversores;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorDivisas {

	public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) throws IOException, JSONException {
		String apiKey = "44233|9*posr*ky9ur^RfO^fGSYwodydFb4BCe";
		String url = "http://api.cambio.today/v1/quotes/" + monedaOrigen + "/" + monedaDestino + "/" + "json" + "?key="
				+ apiKey;

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			Scanner scanner = new Scanner(connection.getInputStream());
			String response = scanner.useDelimiter("\\A").next();
			scanner.close();

			JSONObject jsonObject = new JSONObject(response);
			JSONObject resultObject = jsonObject.getJSONObject("result");
			double tasaDeCambio = resultObject.getDouble("value");

			return tasaDeCambio;

		} else {
			throw new IOException("Error al obtener la tasa de cambio. Código de respuesta: " + responseCode);
		}
	}

	public static double convertirDivisas(String monedaOrigen, String monedaDestino, double monto) {
		try {
			double tasaDeCambio = obtenerTasaDeCambio(monedaOrigen, monedaDestino);
			return monto * tasaDeCambio;
		} catch (JSONException | IOException e) {
			e.printStackTrace(); // Imprimir el seguimiento de la pila (stack trace)
			return 0;
		}
	}
}
