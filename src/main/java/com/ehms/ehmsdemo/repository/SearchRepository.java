package com.ehms.ehmsdemo.repository;

import com.ehms.ehmsdemo.model.Doctor;

import java.util.List;

public interface SearchRepository {

    List<Doctor> searchByTest(String text);

}
