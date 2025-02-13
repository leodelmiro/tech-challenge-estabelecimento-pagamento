package com.leodelmiro.pagamento.entrypoint.api;

import com.leodelmiro.pagamento.core.usecase.pagamento.BuscaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.core.usecase.pagamento.CriaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.mapper.OrdemPagamentoMapper;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;
import com.leodelmiro.pagamento.entrypoint.api.response.OrdemPagamentoResponse;
import com.leodelmiro.pagamento.entrypoint.controller.PagamentoController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pagamento", description = "Endpoints relacionados ao Pagamento")
@RestController
@RequestMapping("/api/v1/pagamentos")
public class OrdemPagamentoApi {
    @Autowired
    private CriaOrdemPagamentoUseCase criaOrdemPagamentoUseCase;

    @Autowired
    private BuscaOrdemPagamentoUseCase buscaOrdemPagamentoUseCase;

    @Autowired
    private OrdemPagamentoMapper ordemPagamentoMapper;

    @Operation(
            summary = "Cria Ordem de Pagamento",
            description = "Cria ordem de Pagamento gerando QR Code de Pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido fechado com sucesso")
    })
    @PostMapping
    public ResponseEntity<OrdemPagamentoResponse> cria(@Valid @RequestBody OrdemPagamentoRequest ordemPagamentoRequest) {
        var pedidoResponse = PagamentoController.criar(ordemPagamentoRequest, criaOrdemPagamentoUseCase, ordemPagamentoMapper);
        return ResponseEntity.ok().body(pedidoResponse);
    }

    @Operation(
            summary = "Busca dados de uma Ordem de Pagamento",
            description = "Retorna os dados de uma ordem de pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido fechado com sucesso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrdemPagamentoResponse> busca(@PathVariable String id) {
        var pedidoResponse = PagamentoController.buscar(id, buscaOrdemPagamentoUseCase, ordemPagamentoMapper);
        return ResponseEntity.ok().body(pedidoResponse);
    }

}
