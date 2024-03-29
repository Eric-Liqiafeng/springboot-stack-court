package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CriminalCase {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long incidentTime;

    @OneToOne(cascade = CascadeType.ALL)
    private CaseInfo caseInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Procuratorate procuratorate;

    public CriminalCase(String name, long incidentTime, CaseInfo caseInfo, Procuratorate procuratorate) {
        this.name = name;
        this.incidentTime = incidentTime;
        this.caseInfo = caseInfo;
        this.procuratorate = procuratorate;
    }

    public CriminalCase() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(long incidentTime) {
        this.incidentTime = incidentTime;
    }

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
