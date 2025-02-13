package bdd.stepdefinitions;

import bdd.config.RestApiApplicationIT;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static bdd.utils.PagamentoHelper.gerarOrdemPagamentoRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

public class PagamentoStepDefinitions extends RestApiApplicationIT {
    private Response response;
    private String ordemPagamentoValida;
    private String baseUrl = "http://localhost:8090/api/v1/pagamentos";

    @Dado("que eu tenho os dados de uma nova ordem de pagamento")
    public void queEuTenhoOsDadosDeUmaNovaOrdemPagamento() {
    }

    @Quando("eu envio uma requisição para criar ordem de pagamento")
    public void euEnvioUmaRequisicaoPOST() {
        response = given()
                .contentType("application/json")
                .body(gerarOrdemPagamentoRequest())
                .when()
                .post(baseUrl);
    }

    @Então("a ordem de pagamento deve ser criada com sucesso status 200")
    public void ordemPagamentoDeveSerCriada() {
        response.then().statusCode(200);
    }

    @Dado("que eu busco uma ordem de pagamento existente")
    public void queEuBuscoUmaOrdemPagamentoExistente() {
        ordemPagamentoValida = given()
                .contentType("application/json")
                .body(gerarOrdemPagamentoRequest())
                .when()
                .post(baseUrl)
                .then().extract().response().path("id");
    }

    @Quando("eu envio uma requisição para buscar ordem de pagamento existente")
    public void euEnvioUmaRequisicaoGETComIdExistente() {
        response = when().get(baseUrl + "/" + ordemPagamentoValida);
    }

    @Então("o pagamento deve ser retornado sucesso com status 200")
    public void produtoDeveSerRetornado() {
        response.then().statusCode(200).body("id", notNullValue());
    }
}
