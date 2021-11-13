package ChouTuanEat.Co.repository;

import ChouTuanEat.Co.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
