package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.eplusi.Occ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OccRepository extends JpaRepository<Occ, Integer> {
    List<Occ> findByOccName(String occName);
}
