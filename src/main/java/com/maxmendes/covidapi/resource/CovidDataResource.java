package com.maxmendes.covidapi.resource;

import com.maxmendes.covidapi.domain.CovidCase;
import com.maxmendes.covidapi.service.CovidCaseService;
import com.maxmendes.covidapi.util.DistanceComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/covidinfo")
public class CovidDataResource {

    @Autowired
    private CovidCaseService covidCaseService;

    private final Double distance = 500.00;

    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    public ResponseEntity<List<CovidCase>> findAll(@RequestBody CovidCase covidCase){

        List<CovidCase> covidCaseList = covidCaseService.findAllCases();
        List<CovidCase> responseCovidList = new ArrayList<>();


        DistanceComparator distanceComparator = new DistanceComparator(covidCase);

        for(CovidCase c : covidCaseList){

            double dist = distanceComparator.distance(covidCase.getLatitude(), covidCase.getLongitude(),
                    c.getLatitude(), c.getLongitude());

            if(dist < distance){
                c.setDistance(dist);
                if(responseCovidList.size() < 51) {
                    responseCovidList.add(c);
                }
            }
        }

        Comparator<CovidCase> compareByDist = (CovidCase o1, CovidCase o2) -> o1.getDistance().compareTo(o2.getDistance());
        Collections.sort(responseCovidList, compareByDist);

        return ResponseEntity.ok(responseCovidList);
    }

    @RequestMapping(value = "/newcase", method = RequestMethod.POST)
    public CovidCase insertCase(@RequestBody CovidCase covidCase){
        return covidCaseService.insertCase(covidCase);
    }
}
