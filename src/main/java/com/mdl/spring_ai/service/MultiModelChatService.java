package com.mdl.spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MultiModelChatService {

    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public MultiModelChatService(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
        this.openAiChatClient = ChatClient.builder(openAiChatModel).build();
        this.ollamaChatClient = ChatClient.builder(ollamaChatModel).build();
    }


    public String chatWthOpenAI(String message) {
        String response="";
        try {
            response = openAiChatClient
                    .prompt(message)
                    .call()
                    .content();
        }catch (Exception e) {
            System.out.println("OpenAiChatClient error"+e.getMessage());
            response=chatWthOpenOLLama(message);
            System.out.println("OllamaChatClient Processing response");
        }
        return response;
    }

    public String chatWthOpenOLLama(String message) {
        return ollamaChatClient
                .prompt(message)
                .call()
                .content();
    }



}
