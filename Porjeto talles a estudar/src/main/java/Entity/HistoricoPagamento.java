package Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class HistoricoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;

    @Column(precision = 10, scale = 2, nullable = false)
    private double valor;

    public HistoricoPagamento() {
    }

    public HistoricoPagamento(LocalDateTime data, FormaPagamento formaPagamento, int id, double valor) {
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.id = id;
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
