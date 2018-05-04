package io.pivotal.actuatordemo.api;

import io.pivotal.actuatordemo.repository.LearnDayRepository;
import io.pivotal.actuatordemo.domain.LearnDay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RefreshScope
public class DemoController {

    @Value("${welcome.message:Dummy}")
    private String helloMessage;

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>(helloMessage, HttpStatus.OK);
    }

    @Autowired
    LearnDayRepository learnDayRepository;

    @PutMapping(value = "/learn", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LearnDay> createLearn(@RequestBody LearnDay learnDay){
        if(Objects.nonNull(learnDay)){
            learnDayRepository.save(learnDay);
            log.info("Persisted: " + learnDay.toString());
        }
        return new ResponseEntity<>(learnDay, HttpStatus.OK);
    }

    @GetMapping(value = "/learns", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<LearnDay>> getLearns(){
        return new ResponseEntity<>(learnDayRepository.findAll(), HttpStatus.OK);
    }
}
