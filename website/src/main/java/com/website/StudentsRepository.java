package com.website;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students,Integer> {
    Students findByUsername(String username);
}
