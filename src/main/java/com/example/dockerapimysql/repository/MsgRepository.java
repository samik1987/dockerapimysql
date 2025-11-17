package com.example.dockerapimysql.repository;

import com.example.dockerapimysql.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgRepository extends JpaRepository<Message,Integer> {
}
