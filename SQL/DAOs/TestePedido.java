package DAOs;

import java.time.LocalDateTime;

public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setDescricao("Pedido de exemplo");

        
        pedido.setEndereco(new Endereco(1)); 
        pedido.setFormaPagamento(new FormaPagamento(1)); 
        pedido.setPromocao(new Promocao(1)); 
        pedido.setRestaurante(new Restaurante(1)); 
        pedido.setStatusEntrega(new StatusEntrega(1)); 
      
        pedido.setTaxa_entrega(5.0); 
        pedido.setTroco(10.0); 
        pedido.setValor(50.0); 
        
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.inserirPedido(pedido); 
    }
}


