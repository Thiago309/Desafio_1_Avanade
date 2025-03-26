package restiapi.projeto1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restiapi.projeto1.domain.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    boolean existsById(Long idAluguel);
}