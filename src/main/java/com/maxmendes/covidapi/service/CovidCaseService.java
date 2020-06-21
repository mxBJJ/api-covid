package com.maxmendes.covidapi.service;

import com.maxmendes.covidapi.domain.CovidCase;
import com.maxmendes.covidapi.repository.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CovidCaseService {

    @Autowired
    private CovidCaseRepository covidCaseRepository;

    public List<CovidCase> findAllCases(){
        return covidCaseRepository.findAll();
    }

    public CovidCase insertCase(CovidCase covidCase){
        return covidCaseRepository.save(covidCase);
    }
}
