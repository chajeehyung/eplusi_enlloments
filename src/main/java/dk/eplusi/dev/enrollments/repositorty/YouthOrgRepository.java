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
    // 페이징 제거로 인한 페이징에서 리스트형으로 변경
    List<YouthOrg> findByYouth(Youth youth);
    List<YouthOrg> findByYouthAndOrganizationAndRoleTypeAndStartDateAndEndDate(Youth youth, Organization organization, RoleType roleType, Date startDate, Date endDate);
}
