package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.eplusi.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByOrgName(String orgName);
    List<Organization> findByOrgNameAndAppliedYear(String orgName, String appliedYear);
    List<Organization> findByAppliedYearBetween(Date start, Date end);
}