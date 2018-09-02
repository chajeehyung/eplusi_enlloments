package dk.eplusi.enrollments.repositorty;

import dk.eplusi.enrollments.model.eplusi.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByAppliedYearBetween(Date start, Date end);
}