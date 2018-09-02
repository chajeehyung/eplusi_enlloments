package dk.eplusi.enrollments.repositorty;

import dk.eplusi.enrollments.model.eplusi.ReligionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReligionTypeRepository extends JpaRepository<ReligionType, Integer> {
    List<ReligionType> findByReligionType(String religionType);
}
