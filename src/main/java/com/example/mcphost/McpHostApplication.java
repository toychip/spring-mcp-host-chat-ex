package com.example.mcphost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class McpHostApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("=== ENV PATH ===");
        System.out.println(System.getenv("PATH"));
        System.out.println("=== npx v ===");
        ProcessBuilder builder = new ProcessBuilder(
                "C:\\Program Files\\nodejs\\npx.cmd", "-v"
        );
        builder.inheritIO();  // 콘솔에 출력
        Process process = builder.start();
        process.waitFor();
        SpringApplication.run(McpHostApplication.class, args);
    }

}
