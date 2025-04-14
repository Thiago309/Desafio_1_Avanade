package restiapi.projeto1.service;
import restiapi.projeto1.domain.model.Aluguel;

/**
 * A interface define as operações relacionadas à entidade Aluguel (Documento dos registros).
 * */

public interface AluguelService {
    Aluguel findById(Long idAluguel);
    Aluguel deleteById(Long idAluguel);
    Aluguel create(Aluguel aluguelToCreate);
    Aluguel update(Aluguel aluguelToUpdate);
}