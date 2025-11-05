package io.jongbeom.springboot.intellij.restfulwebsnsservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//버전에 따른 URL을 선택하여 API의 특정버전 사용 가능
@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return  new PersonV1("종장범");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return  new PersonV2(new Name("종범","장"));
    }

}
