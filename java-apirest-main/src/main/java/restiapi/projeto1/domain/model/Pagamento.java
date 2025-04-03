package restiapi.projeto1.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name ="tb_pagamento")  // Usando @Table para nome de tabela
public class Pagamento {
    @Id
    private Long idPagamento;  // Alterado para Long e nome padronizado

    @OneToOne(cascade = CascadeType.ALL)
    private infoCards cartoes;

    @Column(name = "data_efetuacao", nullable = false)
    private LocalDateTime dataEfetuado;  // Usando LocalDateTime ao invés de Date

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    public Long getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(Long id) {
        this.idPagamento = id;
    }

    public infoCards getCartoes() {return cartoes;}
    public void setCartoes(infoCards cartoes) {this.cartoes = cartoes;}

    public LocalDateTime getDataEfetuado() {
        return dataEfetuado;
    }
    public void setDataEfetuado(LocalDateTime dataEfetuado) {
        this.dataEfetuado = dataEfetuado;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "idPagamento=" + idPagamento +
                ", cartoes=" + cartoes +
                ", dataEfetuado=" + dataEfetuado +
                ", valor=" + valor +
                '}';
    }
}
