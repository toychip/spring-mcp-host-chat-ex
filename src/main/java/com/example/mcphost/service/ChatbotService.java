package com.example.mcphost.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final ChatClient chatClient;

//    public Mono<String> chat(String question) {
//        return chatClient
//                .prompt()
//                .user(question)
//                .stream()
//                .content()
//                .collectList()
//                .map(chunks -> String.join("", chunks));
//    }

    public Mono<String> chat(String question) {
        return chatClient.prompt()
                .user(question)
                .stream()
                .content()
                .collectList()
                .map(chunks -> String.join("", chunks));
    }
}
