package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.code.BizType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BizTypeRepository extends JpaRepository<BizType, Integer> {
    List<BizType> findByBizType(String bizType);
}
