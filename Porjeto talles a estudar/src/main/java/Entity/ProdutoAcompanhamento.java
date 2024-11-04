package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ProdutoAcompanhamento {

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name= "id_acompanhamento")
    private Acompanhamento acompanhamento;

    public ProdutoAcompanhamento() {
    }

    public ProdutoAcompanhamento(Acompanhamento acompanhamento, Produto produto) {
        this.acompanhamento = acompanhamento;
        this.produto = produto;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
