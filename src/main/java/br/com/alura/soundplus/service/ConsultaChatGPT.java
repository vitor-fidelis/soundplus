package br.com.alura.soundplus.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static ChatMessage obterInformacao(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPEN_AI_SECRET_KEY"));

        ChatCompletionRequest requisicao = ChatCompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createChatCompletion(requisicao);
        ChatMessage message = resposta.getChoices().get(0).getText();
        return message;
    }
}
