package edu.eci.arsw.Coronavirus.controller;

import edu.eci.arsw.Coronavirus.services.CoronavirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coronavirus")
public class CoronavirusAPIController {

    @Autowired
    CoronavirusService css;

}
