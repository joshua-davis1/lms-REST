package com.ss.lms.demo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping()
    public List<Publisher> getPublishers() { return publisherService.findAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Publisher findById(@PathVariable Integer id) { return publisherService.findById(id); }

    @PostMapping()
    public void createPublisher(@RequestBody Publisher publisher) { publisherService.save(publisher);}
}
