package restiapi.projeto1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restiapi.projeto1.domain.model.Aluguel;
import restiapi.projeto1.service.AluguelService;
import java.net.URI;

@SpringBootApplication
@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @Operation(summary = "Recupera informações de um registro especifico de aluguel da Base de Dados atraves do id do documento.")
    @GetMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> findById(@PathVariable("idAluguel")Long idAluguel) {
        var aluguel = aluguelService.findById(idAluguel);
        return ResponseEntity.ok(aluguel);
    }

    @Operation(summary = "Deleta um registro de aluguel da Base de Dados")
    @DeleteMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> deleteById(@PathVariable("idAluguel")Long idAluguel) {
        var aluguelDeleted = aluguelService.deleteById(idAluguel);
        return ResponseEntity.ok(aluguelDeleted);
    }

    @Operation(summary = "Adiciona um novo registro de aluguel na Base de Dados")
    @PostMapping
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguelToCreate) {
        var aluguelCreated = aluguelService.create(aluguelToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAluguel}")
                .buildAndExpand(aluguelCreated.getIdAluguel())
                .toUri();

        return ResponseEntity.created(location).body(aluguelCreated);
    }

    @Operation(summary = "Atualiza informações de um registro de aluguel da Base de Dados")
    @PutMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable Long idAluguel, @RequestBody Aluguel aluguelToUpdate) {
        // Validação de consistência
        if (!idAluguel.equals(aluguelToUpdate.getIdAluguel())) {
            return ResponseEntity.badRequest().build();
        }

        Aluguel aluguelAtualizado = aluguelService.update(aluguelToUpdate);
        return ResponseEntity.ok(aluguelAtualizado);
    }
}