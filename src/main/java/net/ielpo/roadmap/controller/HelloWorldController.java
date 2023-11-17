package net.ielpo.roadmap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ielpo.roadmap.dto.HelloWorldResponseDto;
import net.ielpo.roadmap.factory.ResponseFactory;

/**
 * @author Alberto Ielpo
 */
@Component
@RestController
@RequestMapping(value = "hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "{idPath}")
    public ResponseEntity<String> getHello(@RequestParam(value = "id") String id,
            @PathVariable(value = "idPath") String idPath) throws Exception {
        logger.info("this is an id: {} - idPath: {}", id, idPath);

        HelloWorldResponseDto responseDto = new HelloWorldResponseDto("hello world");

        // this cannot be used in a factory
        // ErrorResponseDto errorResponseDto = new ErrorResponseDto("this is an error");

        return ResponseFactory.ok(responseDto);
    }

}
