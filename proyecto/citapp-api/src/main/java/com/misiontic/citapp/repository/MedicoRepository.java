package com.misiontic.citapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.citapp.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	

}
