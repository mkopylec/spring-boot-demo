package com.github.mkopylec.springbootdemo;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class PersonController {

    private static final Logger log = getLogger(PersonController.class);

    private final MongoTemplate mongo;

    public PersonController(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    @GetMapping("/persons-creator")
    public String showPersonCreator(Model model) {
        model.addAttribute("person", new Person());
        return "persons-creator";
    }

    @GetMapping("/persons-viewer")
    public String showPersonViewer(Model model) {
        List<Person> persons = mongo.findAll(Person.class);
        model.addAttribute("persons", persons);
        log.info("Persons found: {}", persons);
        return "persons-viewer";
    }

    @PostMapping("/persons-creator")
    public void createPerson(Person person, Model model) {
        mongo.save(person);
        model.addAttribute("message", "Person " + person.getName() + " " + person.getSurname() + " created.");
        log.info("Person created: {}", person);
    }
}
