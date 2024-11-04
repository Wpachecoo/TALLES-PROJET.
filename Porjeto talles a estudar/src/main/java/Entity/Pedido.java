package Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name= "id_promocao")
    private Promocao promocao;

    @ManyToOne
    @JoinColumn(name = "id_status_entrega")
    private StatusEntrega statusEntrega;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column (nullable = false)
    private LocalDateTime data;

    @Column(precision = 10,scale = 2,nullable = false)
    private double valor;

    @Column(precision = 10,scale = 2,nullable = false)
    private double taxa_entrega;

    @Column(length = 245)
    private String descricao;

    @Column(precision = 10,scale = 2,nullable = false)
    private double troco;

    public Pedido() {
    }

    public Pedido(LocalDateTime data, String descricao, Endereco endereco, FormaPagamento formaPagamento, int id, Promocao promocao,
                  Restaurante restaurante, StatusEntrega statusEntrega, double taxa_entrega, double troco, double valor) {

        this.data = data;
        this.descricao = descricao;
        this.endereco = endereco;
        this.formaPagamento = formaPagamento;
        this.id = id;
        this.promocao = promocao;
        this.restaurante = restaurante;
        this.statusEntrega = statusEntrega;
        this.taxa_entrega = taxa_entrega;
        this.troco = troco;
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public double getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(double taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
