package restiapi.projeto1.service;

import restiapi.projeto1.domain.model.Aluguel;

public interface AluguelService {

    Aluguel findById(Long id);

    Aluguel create(Aluguel aluguelToCreate);
}