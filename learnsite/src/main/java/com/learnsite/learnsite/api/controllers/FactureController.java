package com.learnsite.learnsite.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnsite.learnsite.api.models.Facture;
import com.learnsite.learnsite.api.repositories.FactureRepository;

@RestController
@RequestMapping("/factures")
public class FactureController {
@Autowired
private FactureRepository repo;

@PostMapping("/add")
public ResponseEntity<Facture> addFacture(@RequestBody Facture facture){
	try {
		repo.save(facture);
		return new ResponseEntity<>(facture, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

@GetMapping("/")
@PreAuthorize("hasRole('FORM') or hasRole('ADMIN')")
public ResponseEntity<List<Facture>> getFacture(){
	try {
		List<Facture> factures = repo.findAll();
		if (factures.isEmpty()) {
			return new ResponseEntity<List<Facture>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Facture>>(factures,HttpStatus.OK);
		
	} catch (Exception e) {
		return new ResponseEntity<List<Facture>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@GetMapping("/{id}")
public ResponseEntity<Facture> getFacturebyId(@PathVariable("id") String id){
	try {
		Optional<Facture> factureData = repo.findById(id);
		if (factureData.isPresent()) {
			return new ResponseEntity<Facture>(factureData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

//the update method is not working
@PutMapping("/update/{id}")
public ResponseEntity<Facture> updateFormation(@PathVariable("id") String id, @RequestBody Facture facture){
	Optional<Facture> factureData= repo.findById(id);
	if (factureData.isPresent()) {
		Facture _facture = factureData.get();
	    _facture.setNumber(facture.getNumber());
	    _facture.setTotal(facture.getTotal());
		_facture.setFormateur(facture.getFormateur());
		_facture.setStatus(facture.isStatus());
		repo.save(_facture);
		return  new ResponseEntity<Facture>(_facture,HttpStatus.OK);
	} else {
		return  new ResponseEntity<Facture>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/{id}")
public ResponseEntity<Facture> deleteFacture(@PathVariable("id") String id){
	try {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

@DeleteMapping("/")
public ResponseEntity<Facture> deleteFactures(){
	try {
		repo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

}
