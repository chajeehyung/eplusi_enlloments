package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.code.RoleType;
import dk.eplusi.dev.enrollments.model.common.Organization;
import dk.eplusi.dev.enrollments.model.eplusi.Youth;
import dk.eplusi.dev.enrollments.model.eplusi.YouthOrg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface YouthOrgRepository extends JpaRepository<YouthOrg, Integer> {
    Page<YouthOrg> findByYouth(Youth youth, Pageable pageable);
    List<YouthOrg> findByYouthAndOrganizationAndRoleTypeAndStartDateAndEndDate(Youth youth, Organization organization, RoleType roleType, Date startDate, Date endDate);
}
