package tech.chillo.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.enums.TypeSentiment;
import tech.chillo.sa.service.SentimentService;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment) {
        this.sentimentService.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type) {
        return this.sentimentService.rechercher(type);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id) {
        this.sentimentService.supprimer(id);
    }

}
