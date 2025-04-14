## Desafio_1_Avanade

Publicando minha API REST na Nuvem Usando Spring Boot 3.4.4, Java 21 e Railway 2025.

 ## Sobre a API
A API permite o gerenciamento de registro de alugueis de veiculos, informações dos cartões e veiculos disponiveis no sitema. A seguir, um diagrama de classes representando o sistema.

## Diagrama de Classe (Domínio da API)

```mermaid 
classDiagram
    direction LR
    
    class Veiculo {
        -idVeiculo: Long
        -placa: String
        -modelo: String
        -marca: String
        -categoria: String
        -cor: String
        -KmRodados:Long
        -ano: Integer
        -disponivel: boolean
        -valorDiaria: Double
    }

    class Cliente {
        -idCliente: Long
        -nome: String
        -cpf: String
        -email: String
        -telefone: String
        -estado: String
        -cep: String
        -cidade: String
        -endereco: String
        -complemento: String
    }
    
    class Pagamento {
        -idPagamento: Long
        -idCartao: Long
        -idAluguel: Long
        -dataEfetuado: LocalDate
        -valor: BigDecimal(10,2)
    }

    class infoCard {
        -idCartao: Long
        -numero: Integer
        -cvv: Integer
        -bandeira: String
        -titular: String
        -numeroParcelas: Integer
        -valor: BigDecimal(10,2)
    }

    class Aluguel {
        -idAluguel: Long
        -idVeiculo: Long
        -idCliente: Long
        -dataInicio: LocalDate
        -dataFim: LocalDate
        -valorTotal: BigDecimal(10,2)
    }
    infoCard "1..1" --> "1..1" Pagamento
    Pagamento "1..1" --> "1..1" Aluguel
    Aluguel "1..1" <-- "1..1" Veiculo
    Aluguel "1..1" <-- "1..1" Cliente
```


## Mapa de Camadas

No meu projeto Spring Boot, as camadas podem ser mapeadas da seguinte forma:

Camada de Apresentação (AluguelController): Responsável por receber as requisições HTTP e retornar as respostas 
apropriadas.

Camada de Serviço (AluguelServiceImpl): Contém a lógica de negócio, processando as informações recebidas da camada 
de apresentação e interagindo com a camada de persistência.

Camada de Persistência (AlguelService): Gerencia a comunicação com o banco de dados, realizando 
operações de CRUD (Create, Read, Update, Delete).

Camada de Modelo (Package = domain --> model): Define as entidades e seus atributos, representando as tabelas do 
banco de dados.


## 🎯 Benefícios de Utilizar uma Arquitetura em Camadas
Manutenção Facilitada: Alterações em uma camada têm impacto mínimo nas demais.​

Reutilização de Código: Componentes podem ser reutilizados em diferentes partes do sistema.​

Testabilidade: Facilita a criação de testes unitários e de integração.​

Escalabilidade: Permite que o sistema cresça de forma organizada e sustentável.

![image](https://github.com/user-attachments/assets/4010d8cf-ded0-4366-aa0a-37d1337d43aa) ![image](https://github.com/user-attachments/assets/18853087-e564-4769-b477-269da8637fe8)



## Deploy no Railway

A API está hospedada no Railway. Para acessar, utilize:
```
irei disponibilizar
```  


## 📌 Endpoints

| Método | Endpoint       | Descrição                           |
|--------|----------------|-----------------------------------|
| `GET`  | `/alugueis`    | Retorna um registro de aluguel através do id        |
| `DELETE` | `/alugueis`  | Deleta o registro de aluguel através do id        |
| `POST`  | `/alugueis`    | Atualiza um registro de aluguel pelo id       |
| `CREATE` | `/alugueis`    | Cria um novo registro            |

