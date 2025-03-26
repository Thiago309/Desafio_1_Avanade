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
    public Aluguel create(Aluguel aluguelToCreate) {
        if(aluguelRepository.existsById(aluguelToCreate.getIdAluguel())){
            throw new IllegalArgumentException("Registro de aluguel ja existe no banco de dados.");
        }
        return aluguelRepository.save(aluguelToCreate);
    }
}