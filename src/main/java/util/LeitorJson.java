package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class LeitorJson {
	
	static Map<String, String> mapJson = new HashMap<String, String>(); //Criação do MAPA
	
	static Gson gson = new Gson(); //Gson biblioteca do google para manipular arquivos json
	
	static Reader reader;
	

	public static void main(String[] args) throws IOException {
		reader = new FileReader("./src/main/resources/massaTeste.json");
		mapJson = gson.fromJson(reader, Map.class);
		
		System.out.println(mapJson.get("url"));
		System.out.println(mapJson.get("produto"));
		System.out.println(mapJson.get("valor"));

		gravaArquivoJson();
		
	}

	private static void gravaArquivoJson() throws IOException {
		FileWriter writer = new FileWriter("./src/main/resources/dadosTestes_copy.json");
	    gson.toJson(mapJson,writer);
	    writer.flush();
	    writer.close();
	}

}
