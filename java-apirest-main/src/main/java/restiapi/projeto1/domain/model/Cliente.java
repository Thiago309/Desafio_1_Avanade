package restiapi.projeto1.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")  // Usando @Table para nome de tabela
public class Cliente {
    @Id
    private Long idCliente;  // Alterado para Long e nome padronizado

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", length = 20, nullable = false, unique = true)  // Adicionado unique
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)  // Email único
    private String email;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "cep", length = 20, nullable = false)
    private String cep;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "complemento", nullable = false)
    private String complemento;

    public Long getIdCliente() {return idCliente;}
    public void setIdCliente(Long id) {this.idCliente = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}

    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getComplemento() {return complemento;}
    public void setComplemento(String complemento) {this.complemento = complemento;}

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
