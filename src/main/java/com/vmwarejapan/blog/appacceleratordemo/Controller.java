package com.vmwarejapan.blog.appacceleratordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @PutMapping("/create")
    public void create(@RequestParam String name){
        Entity e = new Entity();
        e.setName(name);
        repository.save(e);
    }

    @GetMapping("/")
    public Iterable<Entity> getAll(){
        return repository.findAll();
    }
}
