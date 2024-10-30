package Entity;

import Entity.FormaPagamento;

@Entity
@Table
public class RestaurantePagamento {

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "id_pagamento")
    private FormaPagamento pagamento;

    public RestaurantePagamento() {
    }

    public RestaurantePagamento(FormaPagamento pagamento, Restaurante restaurante) {
        this.pagamento = pagamento;
        this.restaurante = restaurante;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
