package utilidades;

public class UnidadesUtil {

	public static class Unidad {
		private String simbolo;
		private String nombre;

		public Unidad(String simbolo, String nombre) {
			this.simbolo = simbolo;
			this.nombre = nombre;
		}

		public String getSimbolo() {
			return simbolo;
		}

		public String getNombre() {
			return nombre;
		}

		@Override
		public String toString() {
			return simbolo + " - " + nombre; // Representación de la divisa como String (usada en JComboBox)
		}
	}

	public static Unidad[] getArrayDivisas() {

		Unidad[] arrayUnidades = { new Unidad("ARS", "Peso Argentino"), new Unidad("USD", "Dólar Estadounidense"),
				new Unidad("EUR", "Euro"), new Unidad("AED", "Dirham de los Emiratos Árabes Unidos"),
				new Unidad("ALL", "Lek Albanés"), new Unidad("AOA", "Kwanza Angoleño"),
				new Unidad("AUD", "Dólar Australiano"), new Unidad("AWG", "Florín Arubeño"),
				new Unidad("AZN", "Manat Azerbayano"), new Unidad("BAM", "Marco Convertible de Bosnia y Herzegovina"),
				new Unidad("BBD", "Dólar Barbadiano"), new Unidad("BDT", "Taka Bangladesí"),
				new Unidad("BGN", "Lev Búlgaro"), new Unidad("BHD", "Dinar Bareiní"),
				new Unidad("BIF", "Franco Burundés"), new Unidad("BMD", "Dólar Bermudeño"),
				new Unidad("BND", "Dólar de Brunéi"), new Unidad("BOB", "Boliviano Boliviano"),
				new Unidad("BRL", "Real Brasileño"), new Unidad("BSD", "Dólar Bahameño"),
				new Unidad("BTN", "Ngultrum Butanés"), new Unidad("BWP", "Pula Botsuano"),
				new Unidad("BYR", "Rublo Bielorruso"), new Unidad("BZD", "Dólar Beliceño"),
				new Unidad("CAD", "Dólar Canadiense"), new Unidad("CHF", "Franco Suizo"),
				new Unidad("CLP", "Peso Chileno"), new Unidad("CNY", "Yuan Chino"),
				new Unidad("COP", "Peso Colombiano"), new Unidad("CRC", "Colón Costarricense"),
				new Unidad("CUP", "Peso Cubano"), new Unidad("CVE", "Escudo Caboverdiano"),
				new Unidad("CZK", "Corona Checa"), new Unidad("DJF", "Franco Yibutiano"),
				new Unidad("DKK", "Corona Danesa"), new Unidad("DOP", "Peso Dominicano"),
				new Unidad("DZD", "Dinar Algerino"), new Unidad("EGP", "Libra Egipcia"),
				new Unidad("ERN", "Nakfa Eritreo"), new Unidad("ETB", "Birr Etíope"),
				new Unidad("FJD", "Dólar Fiyiano"), new Unidad("FKP", "Libra Malvinense"),
				new Unidad("GBP", "Libra Esterlina"), new Unidad("GEL", "Lari Georgiano"),
				new Unidad("GHS", "Cedi Ghanés"), new Unidad("GIP", "Libra Gibraltareña"),
				new Unidad("GMD", "Dalasi Gambiano"), new Unidad("GNF", "Franco Guineano"),
				new Unidad("GTQ", "Quetzal Guatemalteco"), new Unidad("GYD", "Dólar Guyanés"),
				new Unidad("HKD", "Dólar de Hong Kong"), new Unidad("HNL", "Lempira Hondureña"),
				new Unidad("HRK", "Kuna Croata"), new Unidad("HTG", "Gourde Haitiano"),
				new Unidad("HUF", "Forint Húngaro"), new Unidad("IDR", "Rupia Indonesia"),
				new Unidad("ILS", "Nuevo Shekel Israelí"), new Unidad("INR", "Rupia India"),
				new Unidad("IQD", "Dinar Iraquí"), new Unidad("IRR", "Rial Iraní"),
				new Unidad("ISK", "Corona Islandesa"), new Unidad("JMD", "Dólar Jamaiquino"),
				new Unidad("JOD", "Dinar Jordaniano"), new Unidad("JPY", "Yen Japonés"),
				new Unidad("KES", "Chelín Keniano"), new Unidad("KGS", "Som Kirguís"),
				new Unidad("KHR", "Riel Camboyano"), new Unidad("KMF", "Franco Comorense"),
				new Unidad("KPW", "Won Norcoreano"), new Unidad("KRW", "Won Surcoreano"),
				new Unidad("KWD", "Dinar Kuwaití"), new Unidad("KYD", "Dólar de Islas Caimán"),
				new Unidad("KZT", "Tenge Kazajo"), new Unidad("LAK", "Kip Laosiano"),
				new Unidad("LBP", "Libra Libanesa"), new Unidad("LKR", "Rupia de Sri Lanka"),
				new Unidad("LRD", "Dólar Liberiano"), new Unidad("LSL", "Loti Lesothense"),
				new Unidad("LYD", "Dinar Libio"), new Unidad("MAD", "Dírham Marroquí"),
				new Unidad("MDL", "Leu Moldavo"), new Unidad("MGA", "Ariary Malgache"),
				new Unidad("MKD", "Denar Macedonio"), new Unidad("MMK", "Kyat de Myanmar"),
				new Unidad("MNT", "Tugrik Mongol"), new Unidad("MOP", "Pataca de Macao"),
				new Unidad("MRO", "Ouguiya Mauritano"), new Unidad("MUR", "Rupia Mauriciana"),
				new Unidad("MVR", "Rufiyaa Maldiva"), new Unidad("MWK", "Kwacha Malauí"),
				new Unidad("MXN", "Peso Mexicano"), new Unidad("MYR", "Ringgit Malayo"),
				new Unidad("NAD", "Dólar Namibio"), new Unidad("NGN", "Naira Nigeriano"),
				new Unidad("NIO", "Córdoba Nicaragüense"), new Unidad("NOK", "Corona Noruega"),
				new Unidad("NPR", "Rupia Nepalesa"), new Unidad("NZD", "Dólar Neozelandés"),
				new Unidad("OMR", "Rial Omaní"), new Unidad("PAB", "Balboa Panameño"), new Unidad("PEN", "Sol Peruano"),
				new Unidad("PGK", "Kina Papuana"), new Unidad("PHP", "Peso Filipino"),
				new Unidad("PKR", "Rupia Pakistaní"), new Unidad("PLN", "Zloty Polaco"),
				new Unidad("PYG", "Guaraní Paraguayo"), new Unidad("QAR", "Riyal de Qatar"),
				new Unidad("RON", "Leu Rumano"), new Unidad("RSD", "Dinar Serbio"), new Unidad("RUB", "Rublo Ruso"),
				new Unidad("RWF", "Franco Ruandés"), new Unidad("SAR", "Riyal Saudí"),
				new Unidad("SBD", "Dólar de Islas Salomón"), new Unidad("SCR", "Rupia de Seychelles"),
				new Unidad("SEK", "Corona Sueca"), new Unidad("SGD", "Dólar de Singapur"),
				new Unidad("SHP", "Libra de Santa Elena"), new Unidad("SLL", "Leone Sierra Leonés"),
				new Unidad("SOS", "Chelín Somalí"), new Unidad("SRD", "Dólar de Surinam"),
				new Unidad("STD", "Dobra Santotomense"), new Unidad("SVC", "Colón Salvadoreño"),
				new Unidad("SYP", "Libra Siria"), new Unidad("SZL", "Lilangeni Suazi"),
				new Unidad("THB", "Baht Tailandés"), new Unidad("TND", "Dinar Tunecino"),
				new Unidad("TOP", "Pa'anga Tongano"), new Unidad("TRY", "Lira Turca"),
				new Unidad("TTD", "Dólar de Trinidad y Tobago"), new Unidad("TWD", "Nuevo Dólar Taiwanés"),
				new Unidad("TZS", "Chelín Tanzano"), new Unidad("UAH", "Grivna Ucraniana"),
				new Unidad("UGX", "Chelín Ugandés"), new Unidad("UYU", "Peso Uruguayo"),
				new Unidad("UZS", "Som Uzbeko"), new Unidad("VND", "Dong Vietnamita"),
				new Unidad("VUV", "Vatu Vanuatuense"), new Unidad("WST", "Tala Samoana"),
				new Unidad("YER", "Rial Yemení"), new Unidad("ZAR", "Rand Sudafricano") };

		
		return arrayUnidades;
	}
	
	public static Unidad[] getArrayUnidadesTemperatura() {
		Unidad[] arrayUnidadesTemperatura = {
            new Unidad("°C", "Grados Celsius"),
            new Unidad("°F", "Grados Fahrenheit"),
            new Unidad("K", "Kelvin")
        };
        return arrayUnidadesTemperatura;
    }
}
