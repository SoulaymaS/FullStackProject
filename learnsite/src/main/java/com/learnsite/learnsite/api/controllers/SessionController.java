package com.learnsite.learnsite.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnsite.learnsite.api.models.Session;
import com.learnsite.learnsite.api.repositories.SessionRepository;

@RestController
@RequestMapping("/sessions")
public class SessionController {

	@Autowired
	private SessionRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<Session> addSession(@RequestBody Session session) {
		try {
		repo.save(session);
		return new ResponseEntity<>(session, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	//Get all resources from database
	@GetMapping("/")
	public ResponseEntity<List<Session>> getSession(){
		try {
			List<Session> sessions = repo.findAll();
			if (sessions.isEmpty()) {
				return new ResponseEntity<List<Session>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Session>>(sessions,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<List<Session>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Session> getSessionbyId(@PathVariable("id") String id){
		try {
			Optional<Session> sessionData = repo.findById(id);
			if (sessionData.isPresent()) {
				return new ResponseEntity<Session>(sessionData.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	//the update method is not working
	@PutMapping("/update/{id}")
	public ResponseEntity<Session> updateSession(@PathVariable("id") String id, @RequestBody Session session){
		Optional<Session> sessionData= repo.findById(id);
		if (sessionData.isPresent()) {
			Session _session = sessionData.get();
			_session.setDate(session.getDate());
			_session.setDuration(session.getDuration());
			_session.setFormation(session.getFormation());
			_session.setSessionStatus(session.isSessionStatus());
			_session.setUsers(session.getUsers());
			repo.save(_session);
			return  new ResponseEntity<Session>(_session,HttpStatus.OK);
		} else {
			return  new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Session> deleteSession(@PathVariable("id") String id){
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	@DeleteMapping("/")
	public ResponseEntity<Session> deleteSessions(){
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
