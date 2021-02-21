package br.com.bookstore.repository;

import br.com.bookstore.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {

}
