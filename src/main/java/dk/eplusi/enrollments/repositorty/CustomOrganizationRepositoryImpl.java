package dk.eplusi.enrollments.repositorty;

import dk.eplusi.enrollments.model.eplusi.Organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomOrganizationRepositoryImpl implements CustomOrganizationRepository {
    public List<Organization> findByAppliedYear(Date appliedYearStart) {
        return new ArrayList<>();
    }
}