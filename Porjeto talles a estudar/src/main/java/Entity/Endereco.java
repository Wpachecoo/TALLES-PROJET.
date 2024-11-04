package Entity;
import jakarta.persistence.*;

import java.io.Serializable; //Informa que os objetos dessa carai de classe pode ser serializado ou desserializados
                             //Serializado é o processo de um objeto ser convertido em um formato que possa ser armazenado ou transmitido
                             //Imagina que você pode armazenar um objeto em um arquivo, para isso, nos temos que implementar o Serializable

@Entity                      //Estou transformando Endereco em uma entidade da tabela
@Table
public class Endereco implements Serializable {
                             //"private transient String senha" caso um campo não deva ser serializado usamos o transient

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Especifica que o banco de dados será responsável por gerar o valor da chame primaria automaticamente
    private int id;                                     //a medida que os registros são inserido.

    @Column(length = 255, nullable = false)             //Quantidade de caracteres e notnull.
    private String rua;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String Estado;

    @Column(length = 10, nullable = false)
    private String CEP;


    @ManyToOne
    @JoinColumn(name="promocao_id")
    private Promocao promocao;

    public Endereco(int i) {
    }

    public Endereco(String bairro, String CEP, String cidade, String estado, int id, Promocao promocao, String rua) {
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        Estado = estado;
        this.id = (int) id;
        this.promocao = promocao;
        this.rua = rua;
    }



    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = (int) id;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}