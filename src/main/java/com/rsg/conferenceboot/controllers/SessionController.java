package com.rsg.conferenceboot.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsg.conferenceboot.models.Session;
import com.rsg.conferenceboot.repositories.SessionRepository;


@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping
	List<Session> list(){
		return sessionRepository.findAll();
	}
	
	@RequestMapping("{id}")
	@GetMapping
	public Session get(@PathVariable Long id)
	{
		return sessionRepository.getOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Session create(@RequestBody final Session session)
	{
		return sessionRepository.saveAndFlush(session);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id)
	{
		sessionRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, 
						  @RequestBody final Session session)
	{
		//validate all attributes are passed otherwise retur 400 bad payload
		Session existingSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, existingSession, "sessionId");
		return sessionRepository.saveAndFlush(existingSession);
	}
	
}
