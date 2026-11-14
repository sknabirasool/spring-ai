package com.mdl.spring_ai.controller;

import com.mdl.spring_ai.service.MultiModelChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/multi-model/api")
public class MultiModelController {

    @Autowired
    private MultiModelChatService multiModelChatService;

    @GetMapping("/chat/openai")
    public String chatWthOpenAI(@RequestParam("message") String message) {
        return multiModelChatService.chatWthOpenAI(message);
    }

    @GetMapping("/chat/ollama")
    public String chatWthOpenOLLama(@RequestParam("message") String message) {
        return multiModelChatService.chatWthOpenOLLama(message);
    }



}
