package com.learnsite.learnsite.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnsite.learnsite.api.repositories.FactureRepository;

@RestController
@RequestMapping("Factures")
public class FactureController {
@Autowired
private FactureRepository repo;

}
