package com.example.demo1509;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Received request for /hello");
        String response = "Hello, world demo!";
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/reverse")
    public String reverseText(@RequestParam String text) {
        System.out.println("Received request for /reverse with text: " + text);
        StringBuilder sb = new StringBuilder(text);
        String reversedText = sb.reverse().toString();
        System.out.println("Sending response: " + reversedText);
        return reversedText;
    }

    // operation to remove all vowels from a string
    @GetMapping("/disemvowel")
    public String disemvowelText(@RequestParam String text) {
        System.out.println("Received request for /disemvowel with text: " + text);
        String disemvoweledText = text.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Sending response: " + disemvoweledText);
        return disemvoweledText;
    }    
    
}
