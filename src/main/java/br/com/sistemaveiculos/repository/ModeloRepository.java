
package br.com.sistemaveiculos.repository;

import br.com.sistemaveiculos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
