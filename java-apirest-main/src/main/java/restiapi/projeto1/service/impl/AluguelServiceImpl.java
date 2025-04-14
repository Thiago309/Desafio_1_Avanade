package restiapi.projeto1.service.impl;

import org.springframework.stereotype.Service;
import restiapi.projeto1.domain.model.Aluguel;
import restiapi.projeto1.domain.repository.AluguelRepository;
import restiapi.projeto1.service.AluguelService;
import java.util.NoSuchElementException;

/**
 * A classe AluguelServiceImpl implementa a lógica de negócio da aplicação relacionada à entidade Aluguel,
 * manipulando registros no banco de dados por meio do AluguelRepository. Representa a camada de serviço da sua
 * aplicação, isolando a lógica de negócio da camada de persistência (repositório) e da camada de
 * apresentação (controllers).
 * */

@Service
public class AluguelServiceImpl implements AluguelService {

    //  O repositório é injetado via construtor. Facilita nos testes da lógica de négocio.
    private AluguelRepository aluguelRepository;

    //  Isso permite usar todos os métodos JPA de AluguelRepository
    public AluguelServiceImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public Aluguel findById(Long idAluguel) {
        //  Busca um aluguel pelo ID. Se o ID não existir, lança NoSuchElementException.
        return aluguelRepository.findById(idAluguel).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aluguel deleteById(Long idAluguel) {
        //  busca o aluguel com o ID fornecido.
        //  Se não encontrar, lança uma exceção com uma mensagem clara.
        Aluguel aluguel = aluguelRepository.findById(idAluguel)
                .orElseThrow(() -> new NoSuchElementException("Aluguel não encontrado com ID: " + idAluguel));
        //  Remove o registro do banco.
        aluguelRepository.deleteById(idAluguel);
        //  Retorna o objeto excluído (opcional, mas útil para feedback ou logs).
        return aluguel;
    }

    @Override
    public Aluguel create(Aluguel aluguelToCreate) {
        //  Verifica se o registro de aluguel já existe atraves do ID.
        if (aluguelRepository.existsById(aluguelToCreate.getIdAluguel())) {
            //  Se já existir, lança IllegalArgumentException.
            throw new IllegalArgumentException("Registro de aluguel ja existe no banco de dados.");
        }
        //  Se for novo, salva no banco de dados.
        return aluguelRepository.save(aluguelToCreate);
    }

    @Override
    public Aluguel update(Aluguel aluguelToUpdate) {
        //  Verifica se o aluguel com o ID especificado não existe.
        if (!aluguelRepository.existsById(aluguelToUpdate.getIdAluguel())) {
            throw new NoSuchElementException("Registro de aluguel não encontrado com ID: " + aluguelToUpdate.getIdAluguel());
        }
        //  Se existir, atualiza os dados no banco.
        return aluguelRepository.save(aluguelToUpdate);
    }
}