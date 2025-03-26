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

    @PostMapping("")
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguelToCreate) {
        var aluguelCreated = aluguelService.create(aluguelToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAluguel}")
                .buildAndExpand(aluguelCreated.getIdAluguel())
                .toUri();
        return ResponseEntity.created(location).body(aluguelCreated);
    }
}