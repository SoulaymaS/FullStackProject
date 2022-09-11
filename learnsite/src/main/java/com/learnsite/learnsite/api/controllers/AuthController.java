package com.learnsite.learnsite.api.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.learnsite.learnsite.api.models.ERole;
import com.learnsite.learnsite.api.models.Formateur;
import com.learnsite.learnsite.api.models.Role;
import com.learnsite.learnsite.api.models.User;
import com.learnsite.learnsite.api.payload.request.LoginRequest;
import com.learnsite.learnsite.api.payload.request.SignupRequest;
import com.learnsite.learnsite.api.payload.response.MessageResponse;
import com.learnsite.learnsite.api.payload.response.UserInfoResponse;
import com.learnsite.learnsite.api.repositories.RoleRepository;
import com.learnsite.learnsite.api.repositories.UserRepository;
import com.learnsite.learnsite.api.security.jwt.JwtUtils;
import com.learnsite.learnsite.api.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	 @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	 
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),
	                                   userDetails.getEmail(),
	                                   roles));
	  }
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }

	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(), 
	                         signUpRequest.getEmail(),
	                         encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRoles();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "form":
	          Role formRole = roleRepository.findByName(ERole.ROLE_FORM)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(formRole);

	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  
	  @GetMapping("/")
	  public ResponseEntity<List<User>> getUsers(){
	  	try {
	  		List<User> formateurs = userRepository.findAll();
	  		if (formateurs.isEmpty()) {
	  			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	  		}
	  		return new ResponseEntity<List<User>>(formateurs,HttpStatus.OK);
	  		
	  	} catch (Exception e) {
	  		return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
	  	}
	  	
	  }
	  @GetMapping("/roles")
	  public ResponseEntity<List<Role>> getRoles(){
	  	try {
	  		List<Role> roles = roleRepository.findAll();
	  		if (roles.isEmpty()) {
	  			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
	  		}
	  		return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);
	  		
	  	} catch (Exception e) {
	  		return new ResponseEntity<List<Role>>(HttpStatus.INTERNAL_SERVER_ERROR);
	  	}
	  	
	  }
}
