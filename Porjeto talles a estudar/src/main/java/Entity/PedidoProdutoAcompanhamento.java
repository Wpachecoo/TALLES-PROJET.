package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class PedidoProdutoAcompanhamento {

    @ManyToOne
    @JoinColumn(name = "id_pedido_produto")
    private PedidoProduto pedidoProduto;

    @ManyToOne
    @JoinColumn(name = "id_acompanhamento")
    private Acompanhamento acompanhamento;

    public PedidoProdutoAcompanhamento() {
    }

    public PedidoProdutoAcompanhamento(Acompanhamento acompanhamento, PedidoProduto pedidoProduto) {
        this.acompanhamento = acompanhamento;
        this.pedidoProduto = pedidoProduto;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public PedidoProduto getPedidoProduto() {
        return pedidoProduto;
    }

    public void setPedidoProduto(PedidoProduto pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }
}
