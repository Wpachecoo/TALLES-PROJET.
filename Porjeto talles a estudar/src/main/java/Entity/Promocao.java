package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
public class Promocao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String codigo;

    @Column (precision = 10, scale = 2, nullable = false)
    private double valor;

    @Column (nullable = false)
    private LocalDateTime validade;

    @Column (length = 50, nullable = false)
    private String tipo;


    public Promocao(int i) {
    }

    public Promocao(String codigo, long id, String nome, String tipo, LocalDateTime validade, double valor) {
        this.codigo = codigo;
        this.id = (int) id;
        this.nome = nome;
        this.tipo = tipo;
        this.validade = validade;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
