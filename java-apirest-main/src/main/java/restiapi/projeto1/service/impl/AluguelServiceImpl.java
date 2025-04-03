package restiapi.projeto1.service.impl;

import org.springframework.stereotype.Service;
import restiapi.projeto1.domain.model.Aluguel;
import restiapi.projeto1.domain.repository.AluguelRepository;
import restiapi.projeto1.service.AluguelService;
import java.util.NoSuchElementException;

// metodo de encapsulamento de informaçoes
@Service
public class AluguelServiceImpl implements AluguelService {

    private AluguelRepository aluguelRepository;

    public AluguelServiceImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public Aluguel findById(Long idAluguel) {
        return aluguelRepository.findById(idAluguel).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aluguel deleteById(Long idAluguel) {
        // 1. Primeiro busca o aluguel para retorná-lo depois da deleção
        Aluguel aluguel = aluguelRepository.findById(idAluguel)
                .orElseThrow(() -> new NoSuchElementException("Aluguel não encontrado com ID: " + idAluguel));

        // 2. Deleta o recurso
        aluguelRepository.deleteById(idAluguel);

        // 3. Retorna o objeto deletado
        return aluguel;
    }

    @Override
    public Aluguel create(Aluguel aluguelToCreate) {
        if (aluguelRepository.existsById(aluguelToCreate.getIdAluguel())) {
            throw new IllegalArgumentException("Registro de aluguel ja existe no banco de dados.");
        }
        return aluguelRepository.save(aluguelToCreate);
    }

    @Override
    public Aluguel update(Aluguel aluguelToUpdate) {
        // Verifica se o registro NÃO existe (correto)
        if (!aluguelRepository.existsById(aluguelToUpdate.getIdAluguel())) {
            throw new NoSuchElementException("Registro de aluguel não encontrado com ID: " + aluguelToUpdate.getIdAluguel());
        }
        return aluguelRepository.save(aluguelToUpdate);
    }
}