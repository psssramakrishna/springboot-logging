package io.javabrains.logging;

import io.javabrains.logging.model.Hello;
import io.javabrains.logging.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloResource {

    @Autowired
    private HelloService helloService;

    public void HelloResource(HelloService helloService){
        this.helloService = helloService;
    }

    //Logger logger = LoggerFactory.getLogger(HelloResource.class);

    @GetMapping("/")
    public String home(){
        log.trace("Home Method Accessed");
        log.debug("Debug Level Message");
        log.info("Info Level Messsage");
        log.warn("Warn Level Message");
        log.error("Error Level Message");
        //return "Hello from Spring boot!";
        return helloService.hello();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello json(){
        return new Hello("Greetings","Hello World");
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello){
        return hello;
    }
}
