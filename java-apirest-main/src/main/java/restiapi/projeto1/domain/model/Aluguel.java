package restiapi.projeto1.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="tb_aluguel")
public class Aluguel {
    @Id
    private Long idAluguel;  // Padronizar para Long ao invés de long

    @OneToOne(cascade = CascadeType.ALL)
    private Veiculo veiculo;  // Renomeado para veiculo (sem "id" no nome)

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;  // Usar LocalDate ao invés de Date (mais moderno)
    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;  // Renomeado para valorTotal para ser mais descritivo

    // Getters e Setters (mantidos, mas ajustados para os novos nomes)
    public Long getIdAluguel() {return idAluguel;}
    public void setIdAluguel(Long id) {this.idAluguel = id;}

    public Veiculo getVeiculo() {return veiculo;}
    public void setVeiculo(Veiculo veiculo) {this.veiculo = veiculo;}

    public Pagamento getPagamento() {return pagamento;}
    public void setPagamento(Pagamento pagamento) {this.pagamento = pagamento;}

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public LocalDate getDataInicio() {return dataInicio;}
    public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}

    public LocalDate getDataFim() {return dataFim;}
    public void setDataFim(LocalDate dataFim) {this.dataFim = dataFim;}

    public BigDecimal getValorTotal() {return valorTotal;}
    public void setValorTotal(BigDecimal valorTotal) {this.valorTotal = valorTotal;}
}