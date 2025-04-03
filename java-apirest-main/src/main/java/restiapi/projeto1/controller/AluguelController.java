package restiapi.projeto1.controller;

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

    @GetMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> findById(@PathVariable("idAluguel")Long idAluguel) {
        var aluguel = aluguelService.findById(idAluguel);
        return ResponseEntity.ok(aluguel);
    }

    @DeleteMapping("/{idAluguel}")
    public ResponseEntity<Aluguel> deleteById(@PathVariable("idAluguel")Long idAluguel) {
        var aluguelDeleted = aluguelService.deleteById(idAluguel);
        return ResponseEntity.ok(aluguelDeleted);
    }

    @PostMapping
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguelToCreate) {
        var aluguelCreated = aluguelService.create(aluguelToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAluguel}")
                .buildAndExpand(aluguelCreated.getIdAluguel())
                .toUri();
        return ResponseEntity.created(location).body(aluguelCreated);
    }

    @PutMapping("/{idAluguel}")  // ID na URL
    public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable Long idAluguel, @RequestBody Aluguel aluguelToUpdate) {
        // Validação de consistência
        if (!idAluguel.equals(aluguelToUpdate.getIdAluguel())) {
            return ResponseEntity.badRequest().build();
        }

        Aluguel aluguelAtualizado = aluguelService.update(aluguelToUpdate);
        return ResponseEntity.ok(aluguelAtualizado);
    }
}