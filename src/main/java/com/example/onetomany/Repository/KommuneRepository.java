package com.example.onetomany.Repository;

import com.example.onetomany.Model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
}
