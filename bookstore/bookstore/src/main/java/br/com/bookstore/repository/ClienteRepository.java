package br.com.bookstore.repository;

import br.com.bookstore.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    void deleteById(Integer idCliente);
}
