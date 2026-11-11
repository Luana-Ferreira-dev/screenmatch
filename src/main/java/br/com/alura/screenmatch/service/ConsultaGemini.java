package br.com.alura.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {

    public static String obterTraducao(String texto){


        String apiKey = System.getenv("GEMINI_API_KEY");

        Client client = Client
                .builder()
                .apiKey(apiKey)
                .build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.6-flash",
                        "Traduza para língua portuguesa o seguinte trecho da forma mais direta," +
                                " não pergunte mais nada, apenas faça: " + texto, null
                );

        return response.text();
    }
}
