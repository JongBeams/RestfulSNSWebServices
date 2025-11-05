package io.jongbeom.springboot.intellij.restfulwebsnsservices.user;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service=service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user =service.findOne(id);

        //페이지 예외 처리
        if(user==null)
            throw new UserNotFoundException("id:"+id);

        return user;
    }

    //GET /users/{id}
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }




    //POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        //@Valid 프로퍼티나 메소드인자 반환 타입의 유효성을 확인하기 위해 표시
        User savedUser =service.save(user);
        // /user/4 => /user/{id} user.getId
        URI location= ServletUriComponentsBuilder   // spring의 http 요청정보 기반 URI를 쉽게 만들어주는 헬퍼 클래스
                .fromCurrentRequest()               // 현재 요청 URL을 가져온다.
                .path("/{id}")                      // 경로 추가
                .buildAndExpand(savedUser.getId())  // {id} 변수를 실제값으로 치환 savedUser.getId값
                .toUri();                           // URI 객체로 변환
        //스프링 프레임워크 클래스, http 패키지 URI loaction 헤더를 받는다
        return ResponseEntity.created(location).build();
    }



}
