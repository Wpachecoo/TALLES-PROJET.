package SQL.DAOs;

import Entity.Pedido;
import Entity.Endereco;
import Entity.FormaPagamento;
import Entity.Promocao;
import Entity.Restaurante;
import Entity.StatusEntrega;

import java.time.LocalDateTime;

public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setDescricao("Pedido de exemplo");

        // Criando instâncias fictícias para os dados necessários
        pedido.setEndereco(new Endereco(1)); // Supondo que o ID do endereço seja 1
        pedido.setFormaPagamento(new FormaPagamento(1)); // Supondo que o ID da forma de pagamento seja 1
        pedido.setPromocao(new Promocao(1)); // Supondo que o ID da promoção seja 1
        pedido.setRestaurante(new Restaurante(1)); // Supondo que o ID do restaurante seja 1
        pedido.setStatusEntrega(new StatusEntrega(1)); // Supondo que o ID do status de entrega seja 1

        // Definindo valores monetários
        pedido.setTaxa_entrega(5.0); // Taxa de entrega
        pedido.setTroco(10.0); // Troco a ser devolvido
        pedido.setValor(50.0); // Valor total do pedido

        // Criando uma instância do PedidoDAO para inserir o pedido
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.inserirPedido(pedido); // Inserindo o pedido no banco de dados
    }
}


