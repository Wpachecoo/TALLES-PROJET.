package Entity;


import jakarta.persistence.*;

@Entity
@Table
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column (length = 245, nullable = false)
    private String descricao;

    public Categoria() {
    }

    public Categoria(String descricao, int id, String nome, String tipo) {
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
