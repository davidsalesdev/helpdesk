package com.example.helpdesk.repositories;


import com.example.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository <Chamado, Integer> {
}
