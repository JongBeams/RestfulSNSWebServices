package io.jongbeom.springboot.intellij.restfulwebsnsservices.helloworld;


import org.springframework.web.bind.annotation.*;

//Rest API 사용
@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")   //path : value와 같음(최신버전이 path)
    @GetMapping(path = "/hello-world") //@GetMapping 사용 시 method = RequestMethod.GET 지정할 필요 없다
    public String helloWorld(){
        return "Hello World";
    }


    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")   //path : value와 같음(최신버전이 path)
    @GetMapping(path = "/hello-world-bean") //@GetMapping 사용 시 method = RequestMethod.GET 지정할 필요 없다
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    // 패스 변수
    // /user/{id}/todos/{id} => /users/2/todos/200
    // /hello-world/path-variable/{name}
    // /hello-world/path-varialbe/Ranga


    @GetMapping(path = "/hello-world/path-variable/{name}") //@GetMapping 사용 시 method = RequestMethod.GET 지정할 필요 없다
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World,%s",name));
    }


}
