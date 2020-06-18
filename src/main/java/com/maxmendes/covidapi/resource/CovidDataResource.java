package com.maxmendes.covidapi.resource;

import com.maxmendes.covidapi.domain.CovidCase;
import com.maxmendes.covidapi.service.CovidCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/covidinfo")
public class CovidDataResource {

    @Autowired
    private CovidCaseService covidCaseService;

    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    public ResponseEntity<Page<CovidCase>> findAll(Pageable pageable){

        Page<CovidCase> covidCaseList = covidCaseService.findAllCases(pageable);
        return ResponseEntity.ok(covidCaseList);
    }

    @RequestMapping(value = "/newcase", method = RequestMethod.POST)
    public CovidCase insertCase(@RequestBody CovidCase covidCase){
        return covidCaseService.insertCase(covidCase);
    }
}
