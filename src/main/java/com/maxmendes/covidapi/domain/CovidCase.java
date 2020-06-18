package com.maxmendes.covidapi.domain;

import com.maxmendes.covidapi.domain.enums.CaseType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_covid")
public class CovidCase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double latitude;
    private Double longitude;
    private Integer status;

    public CovidCase() {
    }

    public CovidCase(Integer id, Double latitude, Double longitude, CaseType status) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status.getCod();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public CaseType getStatus() {
        return CaseType.toEnum(status);
    }

    public void setStatus(CaseType status) {
        this.status = status.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidCase covidCase = (CovidCase) o;
        return id.equals(covidCase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
