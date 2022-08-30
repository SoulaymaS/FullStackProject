package com.learnsite.learnsite.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.learnsite.learnsite.api.models.Formation;
import com.learnsite.learnsite.api.repositories.FormationRepository;

@RestController
@CrossOrigin
@RequestMapping("/formations")
public class FormationController {
	
@Autowired
private FormationRepository repo;
@PostMapping("/add")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Formation> addFormation(@RequestBody Formation formation) {
	try {
	repo.save(formation);
	return new ResponseEntity<>(formation, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
//Get all resources from database

@GetMapping("/")
public ResponseEntity<List<Formation>> getFormation(){
	try {
		List<Formation> formations = repo.findAll();
		if (formations.isEmpty()) {
			return new ResponseEntity<List<Formation>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Formation>>(formations,HttpStatus.OK);
		
	} catch (Exception e) {
		return new ResponseEntity<List<Formation>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@GetMapping("/{id}")
public ResponseEntity<Formation> getFormationbyId(@PathVariable("id") String id){
	try {
		Optional<Formation> formationData = repo.findById(id);
		if (formationData.isPresent()) {
			return new ResponseEntity<Formation>(formationData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

//the update method is not working
@PutMapping("/update/{id}")
public ResponseEntity<Formation> updateFormation(@PathVariable("id") String id, @RequestBody Formation formation){
	Optional<Formation> formationData= repo.findById(id);
	if (formationData.isPresent()) {
		Formation _formation = formationData.get();
		_formation.setTitle(formation.getTitle());
		_formation.setDescription(formation.getDescription());
		_formation.setDuration(formation.getDuration());
	    _formation.setFormateur(formation.getFormateur());
		_formation.setSession(formation.getSession());
		repo.save(_formation);
		return  new ResponseEntity<Formation>(_formation,HttpStatus.OK);
	} else {
		return  new ResponseEntity<Formation>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Formation> deleteFormation(@PathVariable("id") String id){
	try {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

@DeleteMapping("/")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Formation> deleteFormations(){
	try {
		repo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}


}
