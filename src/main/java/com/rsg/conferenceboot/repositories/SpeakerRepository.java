package com.rsg.conferenceboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsg.conferenceboot.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
