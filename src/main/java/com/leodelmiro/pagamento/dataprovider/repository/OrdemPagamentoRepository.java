package com.leodelmiro.pagamento.dataprovider.repository;


import com.leodelmiro.pagamento.dataprovider.repository.entity.OrdemPagamentoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface OrdemPagamentoRepository extends CrudRepository<OrdemPagamentoEntity, String> {
    Optional<OrdemPagamentoEntity> findByIdPedido(Long idPedido);
}
