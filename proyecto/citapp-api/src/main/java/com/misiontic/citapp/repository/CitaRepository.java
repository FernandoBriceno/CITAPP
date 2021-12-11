package com.misiontic.citapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.misiontic.citapp.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	
}
