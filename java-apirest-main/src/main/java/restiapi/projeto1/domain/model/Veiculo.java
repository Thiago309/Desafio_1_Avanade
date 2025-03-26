package restiapi.projeto1.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_veiculos")  // Usando @Table para nome de tabela
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;  // Alterado para Long e nome padronizado

    @Column(name = "placa", unique = true)  // Placa deve ser única
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cor")
    private String cor;

    @Column(name = "quilometros")
    private Long kmRodados;  // Alterado para Long

    @Column(name = "ano")
    private String ano;

    @Column(name = "status")
    private Boolean disponivel;  // Alterado para Boolean

    @Column(name = "preco")  // Corrigido nome (evitar caracteres especiais)
    private BigDecimal valorDiaria;

    // Getters e Setters (ajustados para os novos tipos)
    public Long getIdVeiculo() {return idVeiculo;}
    public void setIdVeiculo(Long id) {this.idVeiculo = id;}

    public String getPlaca() {return placa;}
    public void setPlaca(String placa) {this.placa = placa;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public String getCor() {return cor;}
    public void setCor(String cor) {this.cor = cor;}

    public Long getKmRodados() {return kmRodados;}
    public void setKmRodados(Long kmRodados) {this.kmRodados = kmRodados;}

    public String getAno() {return ano;}
    public void setAno(String ano) {this.ano = ano;}

    public Boolean getDisponivel() {return disponivel;}
    public void setDisponivel(Boolean disponivel) {this.disponivel = disponivel;}

    public BigDecimal getValorDiaria() {return valorDiaria;}
    public void setValorDiaria(BigDecimal valorDiaria) {this.valorDiaria = valorDiaria;}

}
