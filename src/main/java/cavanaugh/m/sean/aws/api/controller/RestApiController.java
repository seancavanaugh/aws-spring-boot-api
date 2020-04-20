package cavanaugh.m.sean.aws.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class RestApiController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public ResponseEntity helloWorld() {
        String profiles = join(" ", environment.getActiveProfiles());
        return new ResponseEntity("Hello World from profiles: " + profiles, OK);
    }
}
