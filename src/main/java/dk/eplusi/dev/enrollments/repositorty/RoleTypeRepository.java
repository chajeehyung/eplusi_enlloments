package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.eplusi.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleTypeRepository extends JpaRepository<RoleType, Integer> {
    List<RoleType> findByRoleName(String roleName);
}
