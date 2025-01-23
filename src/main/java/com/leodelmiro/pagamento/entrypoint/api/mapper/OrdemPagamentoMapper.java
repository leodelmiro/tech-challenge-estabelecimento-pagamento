package com.leodelmiro.pagamento.entrypoint.api.mapper;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;
import com.leodelmiro.pagamento.entrypoint.api.response.OrdemPagamentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdemPagamentoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", ignore = true)
    @Mapping(target = "qrCode", ignore = true)
    @Mapping(target = "pagoEm", ignore = true)
    OrdemPagamento toOrdemPagamento(OrdemPagamentoRequest ordemPagamentoRequest);

    OrdemPagamentoResponse toOrdemPagamentoResponse(OrdemPagamento ordemPagamento);
}
