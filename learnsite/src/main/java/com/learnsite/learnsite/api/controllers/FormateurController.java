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

import com.learnsite.learnsite.api.models.Formateur;
import com.learnsite.learnsite.api.models.Formation;
import com.learnsite.learnsite.api.repositories.FormateurRepository;

@RestController
@RequestMapping("/Formateurs")
public class FormateurController {
	
@Autowired
private FormateurRepository repo;

//Create new resource in database
@PostMapping("/add")
public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur) {
	try {
	repo.save(formateur);
	return new ResponseEntity<>(formateur, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
//Get all resources from database
@GetMapping("/")
public ResponseEntity<List<Formateur>> getFormateur(){
	try {
		List<Formateur> formateurs = repo.findAll();
		if (formateurs.isEmpty()) {
			return new ResponseEntity<List<Formateur>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Formateur>>(formateurs,HttpStatus.OK);
		
	} catch (Exception e) {
		return new ResponseEntity<List<Formateur>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
//Get resource by Id
@GetMapping("/{id}")
public ResponseEntity<Formateur> getFormateurbyId(@PathVariable("id") String id){
	try {
		Optional<Formateur> formateurData = repo.findById(id);
		if (formateurData.isPresent()) {
			return new ResponseEntity<Formateur>(formateurData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@PutMapping("/update/{id}")
public ResponseEntity<Formateur> updateFormateur(@PathVariable("id") String id, @RequestBody Formateur formateur){
	Optional<Formateur> formateurData= repo.findById(id);
	if (formateurData.isPresent()) {
		Formateur _formateur = formateurData.get();
		_formateur.setNom(formateur.getNom());
		_formateur.setPrenom(formateur.getPrenom());
		_formateur.setCin(formateur.getCin());
		_formateur.setProfession(formateur.getProfession());
		_formateur.setSession(formateur.getSession());
		repo.save(_formateur);
		return  new ResponseEntity<Formateur>(_formateur,HttpStatus.OK);
	} else {
		return  new ResponseEntity<Formateur>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/{id}")
public ResponseEntity<Formateur> deleteFormateur(@PathVariable("id") String id){
	try {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

@DeleteMapping("/")
public ResponseEntity<Formateur> deleteFormateurs(){
	try {
		repo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}


}
