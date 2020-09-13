package com.rsg.conferenceboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsg.conferenceboot.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
