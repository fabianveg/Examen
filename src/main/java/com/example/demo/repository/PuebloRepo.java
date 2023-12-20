package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pueblo;

public interface PuebloRepo extends JpaRepository<Pueblo, Integer> {

}
