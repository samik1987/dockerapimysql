package com.example.dockerapimysql.controller;

import com.example.dockerapimysql.entity.Message;
import com.example.dockerapimysql.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private MsgRepository repository;

    @GetMapping("/getmsg/{id}")
    public String getMsgById(@PathVariable int id)
    {
        if(repository.findById(id).map(m-> m.msg).isPresent())
         return repository.findById(id).map(m-> m.msg).get().toString();
        else
            return  "Record not found";
    }

    @PostMapping("/postmsg")
    public String postMsg(@RequestBody String inputMsg)
    {
        int lastId = repository.findAll().stream().sorted((msg1 ,msg2) -> msg2.id - msg1.id)
                .map(i->i.id).findAny().orElse(0);

        repository.save(new Message(lastId+1,inputMsg));

        return "Inserted id -" + (lastId+1);
    }
}
