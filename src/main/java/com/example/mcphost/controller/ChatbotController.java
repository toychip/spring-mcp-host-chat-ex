package com.example.mcphost.controller;

import com.example.mcphost.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;

    @PostMapping("/chat")
    public Mono<ResponseEntity<ChatResponse>> chat(@RequestBody ChatRequest chatRequest) {
        System.out.println("chatRequest.question = " + chatRequest.question());
        return chatbotService.chat(chatRequest.question())
                .map(ChatResponse::new)
                .map(ResponseEntity::ok);
    }
}
