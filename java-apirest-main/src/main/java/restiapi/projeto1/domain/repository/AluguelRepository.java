package restiapi.projeto1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restiapi.projeto1.domain.model.Aluguel;

/**
 * Este metodo verifica se existe um registro de Aluguel com o ID fornecido.
 */

/* Indica que esta interface é um componente do Spring responsável por operações de acesso a dados, como:
   JPA, JDBC e Etc.)*/
@Repository
/*  JpaRepository é uma interface do Spring Data JPA que fornece métodos prontos para operações de CRUD
    e outras funcionalidades, como paginação e ordenação.*/
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    boolean existsById(Long idAluguel);
}