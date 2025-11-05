package io.jongbeom.springboot.intellij.restfulwebsnsservices.jpa;

import io.jongbeom.springboot.intellij.restfulwebsnsservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
