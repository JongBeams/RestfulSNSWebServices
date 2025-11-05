package io.jongbeom.springboot.intellij.restfulwebsnsservices.jpa;

import io.jongbeom.springboot.intellij.restfulwebsnsservices.user.Post;
import io.jongbeom.springboot.intellij.restfulwebsnsservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
