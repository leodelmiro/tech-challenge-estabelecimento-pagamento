package com.leodelmiro.pagamento.dataprovider.repository;


import com.leodelmiro.pagamento.dataprovider.repository.entity.OrdemPagamentoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface OrdemPagamentoRepository extends CrudRepository<OrdemPagamentoEntity, String> {
}
