package restiapi.projeto1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restiapi.projeto1.domain.model.Aluguel;
import restiapi.projeto1.service.AluguelService;
import java.net.URI;

/**
 * A classe AluguelController é responsável por expor os endpoints da API relacionados à entidade Aluguel. Ela atua
 * como a camada de apresentação, recebendo as requisições HTTP, delegando o processamento para a camada de serviço e
 * retornando as respostas apropriadas.
 * */

/* Indica que a classe lida com requisições REST e que os métodos retornam diretamente os dados no corpo da resposta.
   Bean para endpoints REST*/
@RestController
//  Define o caminho base para todos os endpoints deste controller.
@RequestMapping("/alugueis")
public class AluguelController {
    /*  Implementação de injeção de dependência via construtor, uma prática recomendada no Spring Boot. Isso significa
        que, uma vez atribuído, o valor dessa variável não pode ser alterado, promovendo a imutabilidade e a segurança
        do código.*/
    private final AluguelService aluguelService;

    /*  Define um construtor que recebe uma instância de AluguelService como parâmetro. O Spring Boot, ao detectar esse
        construtor, automaticamente injeta a instância apropriada de AluguelService quando cria o bean AluguelController.*/
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @Operation(summary = "Recupera informações de um registro especifico de aluguel da Base de Dados atraves do id do documento.")
    @GetMapping("/{idAluguel}")
    /*  A anotação @PathVariable("idAluguel") Indica que o valor de idAluguel será extraído diretamente da URL da
    requisição para realizar a recuperação da informação da base de dados. Por exemplo, em uma requisição para
    /alugueis/5, o valor 5 será atribuído ao parâmetro idAluguel.*/
    public ResponseEntity<Aluguel> findById(@PathVariable("idAluguel")Long idAluguel) {
        /*  Invoca o metodo findById da camada de serviço, que é responsável por buscar o registro de aluguel
            correspondente ao ID fornecido.*/
        var aluguel = aluguelService.findById(idAluguel);
        /*  Se o registro for encontrado, retorna uma resposta HTTP com status 200 OK, incluindo o objeto Aluguel no
            corpo da resposta.*/
        return ResponseEntity.ok(aluguel);
    }

    @Operation(summary = "Deleta um registro de aluguel da Base de Dados")
    @DeleteMapping("/{idAluguel}")
        /*  A anotação @PathVariable("idAluguel") Indica que o valor de idAluguel será extraído diretamente da URL da
            requisição para realizar a exclusão da base de dados.*/
    public ResponseEntity<Aluguel> deleteById(@PathVariable("idAluguel")Long idAluguel) {
        /*  Verificar se o registro de aluguel com o ID fornecido existe. Caso exista, deleta o registro do banco de
            dados */
        var aluguelDeleted = aluguelService.deleteById(idAluguel);
        //  Retornar o objeto Aluguel deletado.
        return ResponseEntity.ok(aluguelDeleted);
    }

    @Operation(summary = "Adiciona um novo registro de aluguel na Base de Dados")
    @PostMapping
    /*  A anotação @RequestBody indica que o objeto Aluguel será enviado através de uma requisição HTTP como um POST ou
        PUT com dados no corpo em formato JSON, o Spring automaticamente converte esses dados em objeto Java
        correspondente e salva as informações no banco de dados.*/
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguelToCreate) {
        //  Invoca a lógica de negócio para persistir o novo aluguel no banco de dados.
        var aluguelCreated = aluguelService.create(aluguelToCreate);

        /*  ServletUriComponentsBuilder fornece métodos utilitários para facilitar a construção de URLs dinamicamente
            com base na requisição atual.
            O metodo fromCurrentRequest() cria um construtor de URI (UriComponentsBuilder) pre-configurado com as
            informações da requisição HTTP atual. Isso inclui: Esquema ( http ou https), Host (localhost), Porta (8080),
            Caminho da requisição (/alugueis) e o Parâmetros de consulta, se houver (por exemplo, ?status=ativo).*/
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() //fromCurrentRequest() inicia a construção da URI com base na requisição atual, que é /alugueis
                .path("/{idAluguel}")// .path("/{idAluguel}") adiciona o segmento /{idAluguel} ao caminho.
                .buildAndExpand(aluguelCreated.getIdAluguel()) // .buildAndExpand(aluguelCreated.getIdAluguel()) substitui {idAluguel} pelo ID real do aluguel criado.
                .toUri(); // .toUri() converte o resultado em um objeto URI.

        /*  [ResponseEntity.created(location)] Inicia a construção de uma resposta HTTP com o status 201 Created, que
         indica que um novo recurso foi criado com sucesso. [location] É um objeto URI que representa o endereço do novo
         recurso criado, também adiciona automaticamente um cabeçalho HTTP Location na resposta, informando aos clientes
         onde o novo recurso pode ser acessado. Esse URI é geralmente construído com base na requisição atual,
         utilizando o ID do recurso recém-criado. [.body(aluguelCreated)] Define o corpo da resposta HTTP com o objeto
         aluguelCreated, que contém os dados do novo aluguel criado.*/
        return ResponseEntity.created(location).body(aluguelCreated);
    }

    @Operation(summary = "Atualiza informações de um registro de aluguel da Base de Dados")
    @PutMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable Long idAluguel,@RequestBody Aluguel aluguelToUpdate) {
        // Validação de consistência
        if (!idAluguel.equals(aluguelToUpdate.getIdAluguel())) {
            return ResponseEntity.badRequest().build();
        }

        Aluguel aluguelAtualizado = aluguelService.update(aluguelToUpdate);
        return ResponseEntity.ok(aluguelAtualizado);
    }
}