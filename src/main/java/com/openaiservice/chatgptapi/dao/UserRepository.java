package com.openaiservice.chatgptapi.dao;

import com.openaiservice.chatgptapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
