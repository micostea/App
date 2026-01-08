package com.example.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gpt")
public class OpenAIController {

    private ChatClient chatClient;

    public OpenAIController(OpenAiChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);

    }



    @GetMapping("/chat/{message}")
    public String getAnswer(
            @PathVariable String message
    ){
        System.out.println("Test!");
        String response = chatClient
                          .prompt(message)
                          .call()
                          .content();

        return "with Chat Client :" + response;
    }


    @GetMapping("/test")
    public String testEndpoint() {
        System.out.println("Test endpoint hit!");
        return "Test endpoint works!";
    }




}
