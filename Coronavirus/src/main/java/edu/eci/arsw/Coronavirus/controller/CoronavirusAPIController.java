package edu.eci.arsw.Coronavirus.controller;

import edu.eci.arsw.Coronavirus.cache.CoronavirusException;
import edu.eci.arsw.Coronavirus.services.CoronavirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coronavirus")
public class CoronavirusAPIController {

    @Autowired
    CoronavirusService css;

    @GetMapping("/{country}")
    public ResponseEntity<?> countryByName(@PathVariable String country){
        try {
            return new ResponseEntity<>(css.countryByName(country), HttpStatus.ACCEPTED);
        } catch (CoronavirusException e) {
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("info/{country}")
    public ResponseEntity<?> infoCountry(@PathVariable String country){
        try{
            return new ResponseEntity<>(css.infoCountry(country), HttpStatus.ACCEPTED);
        }catch(CoronavirusException e){
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> countries(){
        try {
            return new ResponseEntity<>(css.countries(), HttpStatus.ACCEPTED);
        } catch (CoronavirusException e) {
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
