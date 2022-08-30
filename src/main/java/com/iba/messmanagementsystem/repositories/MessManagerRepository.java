package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.MessManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessManagerRepository extends JpaRepository<MessManager, Integer> {
}
