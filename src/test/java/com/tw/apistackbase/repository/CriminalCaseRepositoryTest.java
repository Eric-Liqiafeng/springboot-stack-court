package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCaseRepositoryTest {

    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Before
    public void setUp() throws Exception{
        List<CriminalCase> criminalCases = new ArrayList<>();
        criminalCases.add(new CriminalCase("caseOne",1531320725));
        criminalCases.add(new CriminalCase("caseTwo",1530320725));
        criminalCases.add(new CriminalCase("caseThree",1530313265));
        criminalCaseRepository.saveAll(criminalCases);
    }

    @Test
    public void should_return_null_when_save_case_some_attribute_are_null(){
        CriminalCase criminalCase = new CriminalCase();
        Assertions.assertThrows(DataIntegrityViolationException.class,()->
                criminalCaseRepository.saveAndFlush(criminalCase)
        );
    }

}