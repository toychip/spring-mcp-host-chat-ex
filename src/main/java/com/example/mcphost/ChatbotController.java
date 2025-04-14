package com.example.mcphost;

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
        System.out.println("chatRequest.question = " + chatRequest.question);
        return chatbotService.chat(chatRequest.question())
                .map(answer -> ResponseEntity.ok(new ChatResponse(answer)));
    }


    public record ChatRequest(String question) {
    }

    public record ChatResponse(String answer) {
    }
}
