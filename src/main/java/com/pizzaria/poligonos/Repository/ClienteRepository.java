package com.pizzaria.poligonos.Repository;

import com.pizzaria.poligonos.Domain.Cliente.ClienteJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteJPA, Long> {
}
