package SQL.DAOs;

import Entity.Pedido;
import SQL.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PedidoDAO {

    public void inserirPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_promocao, id_status_entrega, id_restaurante, id_forma_pagamento, id_endereco, data, valor, taxa_entrega, descricao, troco) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getPromocao().getId()); // id_promocao
            stmt.setInt(2, pedido.getStatusEntrega().getId()); // id_status_entrega
            stmt.setInt(3, pedido.getRestaurante().getId()); // id_restaurante
            stmt.setInt(4, pedido.getFormaPagamento().getId()); // id_forma_pagamento
            stmt.setInt(5, pedido.getEndereco().getId()); // id_endereco
            stmt.setObject(6, pedido.getData()); // data
            stmt.setDouble(7, pedido.getValor()); // valor
            stmt.setDouble(8, pedido.getTaxa_entrega()); // taxa_entrega
            stmt.setString(9, pedido.getDescricao()); // descricao
            stmt.setDouble(10, pedido.getTroco()); // troco

            stmt.executeUpdate(); // Executa a inserção no banco
            System.out.println("Pedido inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

