package org.example.mockito;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tests")
@RestController
@RequiredArgsConstructor
public class TestResource {

    @GetMapping("{id}")
    public String mockTest(@PathVariable("id") String id) {
        System.out.println("mockTest");
        return "actualResult";
    }
}
