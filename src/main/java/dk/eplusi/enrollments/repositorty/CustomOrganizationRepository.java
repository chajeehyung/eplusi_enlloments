package dk.eplusi.enrollments.repositorty;

import dk.eplusi.enrollments.model.eplusi.Organization;

import java.util.Date;
import java.util.List;

public interface CustomOrganizationRepository {
    List<Organization> findByAppliedYear(Date appliedYearStart);
}