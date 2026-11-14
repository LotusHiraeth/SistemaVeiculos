
package br.com.sistemaveiculos.repository;

import br.com.sistemaveiculos.model.Veiculo;
import br.com.sistemaveiculos.model.StatusVeiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("""
        SELECT v FROM Veiculo v
        WHERE (:marca IS NULL OR LOWER(v.marca.nome) LIKE LOWER(CONCAT('%', :marca, '%')))
        AND (:modelo IS NULL OR LOWER(v.modelo.nome) LIKE LOWER(CONCAT('%', :modelo, '%')))
        AND (:ano IS NULL OR v.ano = :ano)
        AND (:precoMin IS NULL OR v.preco >= :precoMin)
        AND (:precoMax IS NULL OR v.preco <= :precoMax)
        AND (:status IS NULL OR v.status = :status)
    """)
    List<Veiculo> filtrar(
            @Param("marca") String marca,
            @Param("modelo") String modelo,
            @Param("ano") Integer ano,
            @Param("precoMin") BigDecimal precoMin,
            @Param("precoMax") BigDecimal precoMax,
            @Param("status") StatusVeiculo status
    );
}
