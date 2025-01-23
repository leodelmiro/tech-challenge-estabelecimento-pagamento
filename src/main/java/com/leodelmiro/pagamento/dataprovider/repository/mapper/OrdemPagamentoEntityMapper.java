package com.leodelmiro.pagamento.dataprovider.repository.mapper;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.repository.entity.OrdemPagamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdemPagamentoEntityMapper {
    OrdemPagamentoEntity toOrdemPagamentoEntity(OrdemPagamento ordemPagamento);

    OrdemPagamento toOrdemPagamento(OrdemPagamentoEntity ordemPagamentoEntity);
}
