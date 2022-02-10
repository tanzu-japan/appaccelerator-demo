package com.vmwarejapan.blog.appacceleratordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoRepository demoRepository;

    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @PutMapping("/create")
    public void create(@RequestParam String name){
        DemoEntity e = new DemoEntity();
        e.setName(name);
        demoRepository.save(e);
    }

    @GetMapping("/")
    public Iterable<DemoEntity> getAll(){
        return demoRepository.findAll();
    }
}
