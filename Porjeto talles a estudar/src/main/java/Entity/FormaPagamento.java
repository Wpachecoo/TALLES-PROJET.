package Entity;

import jakarta.persistence.*;

@Entity
@Table
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String tipo_de_pagamento;

    public FormaPagamento() {
    }

    public FormaPagamento(int id, String tipo_de_pagamento) {
        this.id = id;
        this.tipo_de_pagamento = tipo_de_pagamento;
    }

    public FormaPagamento(int i) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_de_pagamento() {
        return tipo_de_pagamento;
    }

    public void setTipo_de_pagamento(String tipo_de_pagamento) {
        this.tipo_de_pagamento = tipo_de_pagamento;
    }
}
