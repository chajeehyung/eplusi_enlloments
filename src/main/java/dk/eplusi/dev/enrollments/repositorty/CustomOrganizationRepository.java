package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.eplusi.Organization;

import java.util.Date;
import java.util.List;

public interface CustomOrganizationRepository {
    List<Organization> findByAppliedYear(Date appliedYearStart);
}