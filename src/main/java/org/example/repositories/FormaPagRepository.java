package org.example.repositories;

import org.example.entities.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagRepository extends JpaRepository<FormaPagamento, Long> {
}
