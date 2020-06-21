package com.maxmendes.covidapi.repository;

import com.maxmendes.covidapi.domain.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CovidCaseRepository extends JpaRepository<CovidCase,Integer>{
}
