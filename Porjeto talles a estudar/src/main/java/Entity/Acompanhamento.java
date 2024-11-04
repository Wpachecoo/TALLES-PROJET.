package Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Acompanhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (length = 100, nullable = false)
    private String nome;

    @Column (length = 245)
    private String descricao;

    @Column(precision = 10, scale = 2, nullable = false)
    private double acompanhamento;


    public Acompanhamento() {
    }

    public Acompanhamento(double acompanhamento, String descricao, int id, String nome) {
        this.acompanhamento = acompanhamento;
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
    }

    public double getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(double acompanhamento) {
        this.acompanhamento = acompanhamento;
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
}
