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

import com.learnsite.learnsite.api.models.Theme;
import com.learnsite.learnsite.api.repositories.ThemeRepository;

@RestController
@RequestMapping("/Themes")
public class ThemeController {

	
@Autowired
private ThemeRepository repo;

@PostMapping("/add")
public ResponseEntity<Theme> addTheme(@RequestBody Theme theme) {
	try {
	repo.save(theme);
	return new ResponseEntity<>(theme, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
//Get all resources from database
@GetMapping("/")
public ResponseEntity<List<Theme>> getTheme(){
	try {
		List<Theme> themes = repo.findAll();
		if (themes.isEmpty()) {
			return new ResponseEntity<List<Theme>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Theme>>(themes,HttpStatus.OK);
		
	} catch (Exception e) {
		return new ResponseEntity<List<Theme>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@GetMapping("/{id}")
public ResponseEntity<Theme> getThemebyId(@PathVariable("id") String id){
	try {
		Optional<Theme> themeData = repo.findById(id);
		if (themeData.isPresent()) {
			return new ResponseEntity<Theme>(themeData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

//the update method is not working
@PutMapping("/update/{id}")
public ResponseEntity<Theme> updateTheme(@PathVariable("id") String id, @RequestBody Theme theme){
	Optional<Theme> themeData= repo.findById(id);
	if (themeData.isPresent()) {
		Theme _theme = themeData.get();
		_theme.setTitle(theme.getTitle());
		_theme.setFormation(theme.getFormation());
		repo.save(_theme);
		return  new ResponseEntity<Theme>(_theme,HttpStatus.OK);
	} else {
		return  new ResponseEntity<Theme>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/{id}")
public ResponseEntity<Theme> deleteTheme(@PathVariable("id") String id){
	try {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

@DeleteMapping("/")
public ResponseEntity<Theme> deleteThemes(){
	try {
		repo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

	
}
