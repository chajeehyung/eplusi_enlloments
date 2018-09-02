package dk.eplusi.enrollments.repositorty;

import dk.eplusi.enrollments.model.eplusi.Youth;
import dk.eplusi.enrollments.model.eplusi.YouthOrg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YouthOrgRepository extends JpaRepository<YouthOrg, Integer> {
    Page<YouthOrg> findByYouth(Youth youth, Pageable pageable);
}
