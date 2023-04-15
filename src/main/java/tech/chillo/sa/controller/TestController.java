package tech.chillo.sa.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping
    public List<String> getList() {
        return List.of("Chaine de caractère" ,"transmise par SA");
    }

    @GetMapping(path = "string")
    public String getString() {
        return "Chaine de caractère transmise par SA";
    }

}
