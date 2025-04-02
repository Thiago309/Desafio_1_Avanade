package restiapi.projeto1.service;
import restiapi.projeto1.domain.model.Aluguel;

public interface AluguelService {

    Aluguel findById(Long idAluguel);
    Aluguel create(Aluguel aluguelToCreate);
    Aluguel update(Aluguel aluguelToUpdate);

}