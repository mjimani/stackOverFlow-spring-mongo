package ir.mjimani.demo.repository;

import ir.mjimani.demo.domain.Medicines;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepository extends MongoRepository<Medicines, String> {
}