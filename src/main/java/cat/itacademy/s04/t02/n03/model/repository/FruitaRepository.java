package cat.itacademy.s04.t02.n03.model.repository;

import cat.itacademy.s04.t02.n03.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitaRepository extends MongoRepository<Fruita, String> {
}
