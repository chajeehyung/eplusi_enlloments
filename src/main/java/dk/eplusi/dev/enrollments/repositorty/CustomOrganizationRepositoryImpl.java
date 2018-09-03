package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.eplusi.Organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomOrganizationRepositoryImpl implements CustomOrganizationRepository {
    public List<Organization> findByAppliedYear(Date appliedYearStart) {
        return new ArrayList<>();
    }
}