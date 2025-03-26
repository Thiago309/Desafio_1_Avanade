package restiapi.projeto1.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cartoes")
public class infoCards {
    @Id
    private Long idCartao;

    @Column(name = "numero_cartao", nullable = false, length = 16, unique = true)
    private int numero;
    @Column(length = 3, name = "codigo", nullable = false)
    private int cvv;
    @Column(name = "bandeira", nullable = false)
    private String bandeira;
    @Column(name = "titular", nullable = false)
    private String titular;
    @Column(name = "numero_parcelas", nullable = false)
    private int parcelas;
    @Column(name = "valor_compra", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    public Long getIdCartao() {return idCartao;}
    public void setIdCartao(Long idCartao) {this.idCartao = idCartao;}

    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}

    public int getCvv() {return cvv;}
    public void setCvv(int cvv) {this.cvv = cvv;}

    public String getBandeira() {return bandeira;}

    public void setBandeira(String bandeira) {this.bandeira = bandeira;}

    public String getTitular() {return titular;}
    public void setTitular(String titular) {this.titular = titular;}

    public int getNumeroParcelas() {return parcelas;}
    public void setNumeroParcelas(int numeroParcelas) {this.parcelas = numeroParcelas;}

    public BigDecimal getValor() {return valor;}
    public void setValor(BigDecimal valor) {this.valor = valor;}
}

