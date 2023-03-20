package com.ehms.ehmsdemo.repository;

import com.ehms.ehmsdemo.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
