package dk.eplusi.dev.enrollments.attributeSetter;

import dk.eplusi.dev.enrollments.common.DateUtility;
import dk.eplusi.dev.enrollments.common.StringUtility;
import dk.eplusi.dev.enrollments.model.code.RoleType;
import dk.eplusi.dev.enrollments.model.common.Organization;
import dk.eplusi.dev.enrollments.model.eplusi.Youth;
import dk.eplusi.dev.enrollments.model.eplusi.YouthOrg;
import dk.eplusi.dev.enrollments.repositorty.OrganizationRepository;
import dk.eplusi.dev.enrollments.repositorty.RoleTypeRepository;
import dk.eplusi.dev.enrollments.repositorty.YouthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class YouthOrgAttributeSetter {

    private final YouthRepository youthRepository;
    private final OrganizationRepository organizationRepository;
    private final RoleTypeRepository roleTypeRepository;

    @Autowired
    public YouthOrgAttributeSetter(YouthRepository youthRepository, OrganizationRepository organizationRepository, RoleTypeRepository roleTypeRepository) {
        this.youthRepository = youthRepository;
        this.organizationRepository = organizationRepository;
        this.roleTypeRepository = roleTypeRepository;
    }

    public YouthOrg setAttributes(Youth youth, Organization organization, RoleType roleType, Date startDate, Date endDate) {
        if(youth == null || organization == null || roleType == null || startDate == null || endDate == null)
            throw new IllegalArgumentException("All attributes excepts for youth_org_id should not be null.");

        YouthOrg youthOrg = new YouthOrg();
        youthOrg.setYouth(youth);
        youthOrg.setOrganization(organization);
        youthOrg.setRoleType(roleType);
        youthOrg.setStartDate(startDate);
        youthOrg.setEndDate(endDate);
        return youthOrg;
    }

    public YouthOrg setAttributes(HttpServletRequest request) throws IllegalArgumentException {
        Youth youth;
        Organization organization;
        RoleType roleType;
        Date startDate;
        Date endDate;

        String youthName = request.getParameter("youthName");
        String youthPeer = request.getParameter("youthPeer");
        String orgCode = request.getParameter("orgCode");
        String roleCode = request.getParameter("roleCode");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        if(StringUtility.isEmtpyOrNull(youthName)) {
            throw new IllegalArgumentException("청년 이름이 올바르지 않습니다.");
        } else if(StringUtility.isEmtpyOrNull(youthPeer)) {
            throw new IllegalArgumentException("청년 또래가 올바르지 않습니다.");
        } else {
            List<Youth> youths = youthRepository.findByYouthNameAndYouthPeer(youthName, youthPeer);
            if (youths == null || youths.isEmpty())
                throw new IllegalArgumentException(youthPeer + "또래 " + youthName + " 청년에 해당하는 청년 정보를 찾을 수 없습니다.");
            else
                youth = youths.get(0);
        }

        if(StringUtility.isEmtpyOrNull(orgCode)) {
            throw new IllegalArgumentException("조직이 올바르지 않습니다.");
        } else {
            try {
                Optional<Organization> optional = organizationRepository.findById(Integer.valueOf(orgCode));
                if(optional.isPresent())
                    organization = optional.get();
                else
                    throw new IllegalArgumentException(orgCode + "에 해당하는 조직 정보를 찾을 수 없습니다.");
            } catch (Exception e) {
                throw new IllegalArgumentException(orgCode + "에 해당하는 조직 정보를 찾을 수 없습니다.", e);
            }
        }

        if(StringUtility.isEmtpyOrNull(roleCode)) {
            throw new IllegalArgumentException("직분이 올바르지 않습니다.");
        } else {
            try {
                Optional<RoleType> optional = roleTypeRepository.findById(Integer.valueOf(roleCode));
                if(optional.isPresent())
                    roleType = optional.get();
                else
                    throw new IllegalArgumentException(orgCode + "에 해당하는 직분 정보를 찾을 수 없습니다.");
            } catch (Exception e) {
                throw new IllegalArgumentException(orgCode + "에 해당하는 직분 정보를 찾을 수 없습니다.", e);
            }
        }

        if(StringUtility.isEmtpyOrNull(startDateStr)) {
            throw new IllegalArgumentException("시작 날짜가 올바르지 않습니다.");
        } else {
            try {
                startDate = DateUtility.parse(startDateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("다음 값은 올바른 날짜 형식이 아닙니다: " + startDateStr);
            }
        }

        if(StringUtility.isEmtpyOrNull(endDateStr)) {
            throw new IllegalArgumentException("종료 날짜가 올바르지 않습니다.");
        } else {
            try {
                endDate = DateUtility.parse(endDateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("다음 값은 올바른 날짜 형식이 아닙니다: " + endDateStr);
            }
        }

        return setAttributes(youth, organization, roleType, startDate, endDate);
    }


}
