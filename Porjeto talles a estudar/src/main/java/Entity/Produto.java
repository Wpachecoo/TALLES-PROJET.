package Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100 ,nullable = false)
    private String nome;

    @Column(length = 245)
    private String descricao;

    @Column(precision = 10, scale = 2, nullable = false)
    private double preco;

    @ManyToOne
    @JoinColumn(name= "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name= "restaurante_id")
    private Restaurante restaurante;

    public Produto() {
    }

    public Produto(Categoria categoria, String descricao, int id, String nome, double preco, Restaurante restaurante) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.restaurante = restaurante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
