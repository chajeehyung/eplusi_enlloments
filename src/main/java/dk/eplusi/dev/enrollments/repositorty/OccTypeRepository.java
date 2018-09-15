package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.code.OccType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OccTypeRepository extends JpaRepository<OccType, Integer> {
    List<OccType> findByOccType(String occType);
}
