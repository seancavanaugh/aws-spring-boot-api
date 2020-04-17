package cavanaugh.m.sean.aws.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class RestApiController {

    @GetMapping("/")
    public ResponseEntity helloWorld() {
        return new ResponseEntity("Hello World", OK);
    }
}
