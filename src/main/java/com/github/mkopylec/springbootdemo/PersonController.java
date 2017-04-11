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

    @GetMapping("/person-creator")
    public String showPersonCreator(Model model) {
        model.addAttribute("person", new Person());
        return "person-creator";
    }

    @GetMapping("/person-viewer")
    public String showPersonViewer(Model model) {
        List<Person> persons = mongo.findAll(Person.class);
        model.addAttribute("persons", persons);
        log.info("Persons found: {}", persons);
        return "person-viewer";
    }

    @PostMapping("/person-creator")
    public void createPerson(Person person, Model model) {
        mongo.save(person);
        model.addAttribute("message", "Person created: " + person.getName() + " " + person.getSurname());
        log.info("Person created: {}", person);
    }
}
