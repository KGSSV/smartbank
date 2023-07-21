package com.brillio.controller;

import com.brillio.model.JwtRequest;
import com.brillio.model.JwtResponse;
import com.brillio.model.Transaction;
import com.brillio.service.UserDetailsServiceImpl;
import com.brillio.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            UserDetailsServiceImpl userDetailsService,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User ");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);


//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setBearerAuth(token); // Assuming you have the token after successful authentication
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<Transaction[]> response = restTemplate.exchange("http://localhost:8080/api/users/transactions", HttpMethod.GET, entity, Transaction[].class);
//        Transaction[] transactions = response.getBody();

        //return ResponseEntity.ok().header("Authorization", "Bearer " + token).body(redirectView);


        String redirectUrl = "transactions.html";
        return ResponseEntity.ok(new JwtResponse(token));
         //return ResponseEntity.ok(new JwtResponse(token));
    }
}
