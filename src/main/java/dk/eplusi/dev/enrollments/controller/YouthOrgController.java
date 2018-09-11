package dk.eplusi.dev.enrollments.controller;

import dk.eplusi.dev.enrollments.common.DateUtility;
import dk.eplusi.dev.enrollments.model.eplusi.Organization;
import dk.eplusi.dev.enrollments.model.eplusi.RoleType;
import dk.eplusi.dev.enrollments.model.eplusi.Youth;
import dk.eplusi.dev.enrollments.model.eplusi.YouthOrg;
import dk.eplusi.dev.enrollments.repositorty.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Gyummy on 2017-08-10.
 *
 */
@Controller
public class YouthOrgController {
    private static final Logger LOGGER = LoggerFactory.getLogger(YouthOrgController.class);

    private YouthOrg setYouthOrgInformation (YouthOrg youthOrg, HttpServletRequest request) throws ParseException {
        Youth youth = null;
        String youthId = request.getParameter("youthId");
        if(youthId != null) {
            Optional<Youth> result = youthRepository.findById(Integer.valueOf(youthId));
            if(result.isPresent())
                youth = result.get();
        } else {
            String youthName = request.getParameter("youthName");
            String youthPeer = request.getParameter("youthPeer");
            if(youthName != null && !youthName.isEmpty() && youthPeer != null && !youthPeer.isEmpty()) {
                List<Youth> youths = youthRepository.findByYouthNameAndYouthPeer(youthName, youthPeer);
                if(youths != null && !youths.isEmpty())
                    youth = youths.get(0);
            }
        }

        if(youth != null)
            youthOrg.setYouth(youth);

        youthOrg.setRoleType(roleTypeRepository.getOne(Integer.valueOf(request.getParameter("roleCode"))));
        youthOrg.setOrganization(organizationRepository.getOne(Integer.valueOf(request.getParameter("orgCode"))));
        youthOrg.setStartDate(DateUtility.getThisYear());
        youthOrg.setEndDate(DateUtility.getNextYear());

        return youthOrg;
    }

    private final YouthRepository youthRepository;
    private final YouthOrgRepository youthOrgRepository;
    private final OrganizationRepository organizationRepository;
    private final RoleTypeRepository roleTypeRepository;

    @Autowired
    public YouthOrgController(YouthRepository youthRepository, YouthOrgRepository youthOrgRepository,
                              OrganizationRepository organizationRepository, RoleTypeRepository roleTypeRepository) {
        this.youthRepository = youthRepository;
        this.youthOrgRepository = youthOrgRepository;
        this.organizationRepository = organizationRepository;
        this.roleTypeRepository = roleTypeRepository;
    }

    private static final Map<String, String> keywordMap = new LinkedHashMap<>();
    static {
        keywordMap.put("youthName", "청년 이름");
    }

    @GetMapping(value = "/youthOrgSearch")
    public String youthOrgSearchGet(HttpServletRequest request, Model model, Pageable pageable) throws Exception {
        return youthOrgSearchPost(request, model, pageable);
    }

    @PostMapping(value = "/youthOrgSearch")
    public String youthOrgSearchPost(HttpServletRequest request, Model model, @PageableDefault(size = 20) Pageable pageable) throws Exception {
        Page<YouthOrg> result = null;
        String target = request.getParameter("target");
        String keyword = request.getParameter("keyword");
        model.addAttribute("target", target);
        model.addAttribute("keyword", keyword);
        if (target != null && !target.isEmpty() && keyword != null && !keyword.isEmpty()) {
            switch (target) {
                case "youthName":
                    List<Youth> youthSearched = youthRepository.findByYouthName(keyword);
                    if(!youthSearched.isEmpty())
                        result = youthOrgRepository.findByYouth(youthSearched.get(0), pageable);
                    break;
            }
        }
        if(result == null)
        result = youthOrgRepository.findAll(pageable);

        model.addAttribute("size", result.getTotalElements());
        model.addAttribute("youthOrgList", result.getContent());
        model.addAttribute("keywordMap", keywordMap);

        List<Integer> pageNumbers = new ArrayList<>();
        for(int i = 0; i < result.getTotalPages(); i++)
            pageNumbers.add(i);
        model.addAttribute("pageNumbers", pageNumbers);

        return "youthOrg/youthOrgSearch";
    }

    @GetMapping(value = "youthOrgInsert")
    public String youthOrgInsertGet(Model model) throws Exception {
        return youthOrgInsertPost(model);
    }

    @PostMapping(value = "youthOrgInsert")
    public String youthOrgInsertPost(Model model) throws Exception {
        model.addAttribute("roleTypeList", roleTypeRepository.findAll());
        model.addAttribute("orgList", organizationRepository.findByAppliedYearBetween(DateUtility.getThisYear(), DateUtility.getNextYear()));
        return "youthOrg/youthOrgInsert";
    }

    @PostMapping(value = "youthOrgInsertResult")
    public String youthOrgInsertResult(HttpServletRequest request, Model model) throws Exception {
        YouthOrg youthOrg = setYouthOrgInformation(new YouthOrg(), request);
        model.addAttribute("youthOrg", youthOrg);
        YouthOrg saveResult = youthOrgRepository.save(youthOrg);
        model.addAttribute("youthOrgId", saveResult.getYouthOrgId());
        model.addAttribute("success", youthOrg.equals(saveResult));

        return "youthOrg/youthOrgInsertResult";
    }

    @PostMapping(value = "youthOrgModify")
    public String youthOrgModify(HttpServletRequest request, Model model) throws Exception {
        Integer youthOrgId = Integer.valueOf(request.getParameter("youthOrgId"));
        Optional<YouthOrg> result = youthOrgRepository.findById(youthOrgId);
        if(result.isPresent()) {
            YouthOrg youthOrg = result.get();
            model.addAttribute("youthOrg", youthOrg);

//            List<Map<String, Object>> occTypeList = new ArrayList<>();
//            occTypeRepository.findAll().forEach(occType -> {
//                Map<String, Object> occTypeMap = new HashMap<>();
//                occTypeMap.put("key", occType.getOccTypeCode());
//                occTypeMap.put("value", occType.getOccType());
//                if(occType.equals(youthOrg.getOccType()))
//                    occTypeMap.put("selected", true);
//                occTypeList.add(occTypeMap);
//            });
//            model.addAttribute("occTypeList", occTypeList);
//
//            List<Map<String, Object>> occList = new ArrayList<>();
//            occRepository.findAll().forEach(occ -> {
//                Map<String, Object> occMap = new HashMap<>();
//                occMap.put("key", occ.getOccCode());
//                occMap.put("value", occ.getOccName());
//                if(occ.equals(youthOrg.getOcc()))
//                    occMap.put("selected", true);
//                occList.add(occMap);
//            });
//            model.addAttribute("occList", occList);
//
//            List<Map<String, Object>> bizTypeList = new ArrayList<>();
//            bizTypeRepository.findAll().forEach(bizType -> {
//                Map<String, Object> bizTypeMap = new HashMap<>();
//                bizTypeMap.put("key", bizType.getBizTypeCode());
//                bizTypeMap.put("value", bizType.getBizType());
//                if(bizType.equals(youthOrg.getBizType()))
//                    bizTypeMap.put("selected", true);
//                bizTypeList.add(bizTypeMap);
//            });
//            model.addAttribute("bizTypeList", bizTypeList);
//
//            List<Map<String, Object>> religionTypeList = new ArrayList<>();
//            religionTypeRepository.findAll().forEach(religionType -> {
//                Map<String, Object> religionTypeMap = new HashMap<>();
//                religionTypeMap.put("key", religionType.getReligionTypeCode());
//                religionTypeMap.put("value", religionType.getReligionType());
//                if(religionType.equals(youthOrg.getReligionType()))
//                    religionTypeMap.put("selected", true);
//                religionTypeList.add(religionTypeMap);
//            });
//            model.addAttribute("religionTypeList", religionTypeList);
        }

        return "youthOrg/youthOrgModify";
    }

    @PostMapping(value = "youthOrgModifyResult")
    public String youthOrgModifyResult(HttpServletRequest request, Model model) throws Exception {
        Integer youthOrgId = Integer.valueOf(request.getParameter("youthOrgId"));
        Optional<YouthOrg> result = youthOrgRepository.findById(youthOrgId);
        if(result.isPresent()) {
            YouthOrg youthOrg = setYouthOrgInformation(result.get(), request);
            model.addAttribute("youthOrg", youthOrg);
            YouthOrg saveResult = youthOrgRepository.save(youthOrg);
            model.addAttribute("success", youthOrg.equals(saveResult));
        }
        return "youthOrg/youthOrgModifyResult";
    }

    @GetMapping(value = "youthOrgDetail")
    public String youthOrgDetail(HttpServletRequest request, Model model) throws Exception {
        Integer youthOrgId = Integer.valueOf(request.getParameter("youthOrgId"));
        Optional<YouthOrg> result = youthOrgRepository.findById(youthOrgId);
        model.addAttribute("found", result.isPresent());
        if(result.isPresent()) {
            YouthOrg youthOrg = result.get();
            model.addAttribute("youthOrg", youthOrg);
        }
        return "youthOrg/youthOrgDetail";
    }

    @PostMapping(value = "youthOrgDeleteResult")
    public String youthOrgDeleteResult(HttpServletRequest request, Model model) throws Exception {
        Integer youthOrgId = Integer.valueOf(request.getParameter("youthOrgId"));
        Optional<YouthOrg> result = youthOrgRepository.findById(youthOrgId);
        if(result.isPresent()) {
            YouthOrg youthOrg = result.get();
            youthOrgRepository.delete(youthOrg);
            model.addAttribute("name", youthOrg.getYouth().getYouthName());
            model.addAttribute("success", true);
        } else {
            model.addAttribute("success", false);
        }
        return "youthOrg/youthOrgDeleteResult";
    }

    @GetMapping(value = "youthOrgInsertFile")
    public String youthOrgInsertFile() {
        return "youthOrg/youthOrgInsertFile";
    }

    //TODO error 처리
    @PostMapping(value = "youthOrgInsertFileResult")
    public String youthOrgInsertFileResult(MultipartFile[] files, Model model) {
        for(MultipartFile multipartFile : files) {
            try {
                int size = (int) multipartFile.getSize();
                byte[] bytes = new byte[size];
                int read = multipartFile.getInputStream().read(bytes, 0, size);
                if(read != size)
                    LOGGER.warn("The read count does not same with uploaded file size. (size=" + size + ", read=" + read + ")");

                String fileContents = new String(bytes, "EUC-KR");
                String[] lines = fileContents.split("\r\n");
                for(String line : lines) {
                    LOGGER.debug("Line: " + line);
                    String[] values = line.split(",");
                    if(values.length != 5) {
                        LOGGER.warn("The line is invalid youthOrg information: " + line);
                        continue;
                    }

                    String youthName = values[0];
                    String youthPeer = values[1];
                    String orgName = values[2];
                    String roleName = values[3];
                    String appliedYear = values[4];

                    List<Youth> youths = youthRepository.findByYouthNameAndYouthPeer(youthName, youthPeer);
                    if(youths == null || youths.isEmpty()) {
                        LOGGER.warn("There is no Youth for the given information. (youthName=" + youthName + ", youthPeer=" + youthPeer + ")");
                        continue;
                    } else if(youths.size() > 1) {
                        LOGGER.warn("There are " + youths.size() + " results for the given information. (youthName=" + youthName + ", youthPeer=" + youthPeer + ")");
                    }
                    Youth youth = youths.get(0);

                    List<Organization> organizations = organizationRepository.findByOrgNameAndAppliedYear(orgName, appliedYear);
                    if(organizations == null || organizations.isEmpty()) {
                        LOGGER.warn("There is no Organization for the given information. (orgName=" + orgName + ")");
                        continue;
                    } else if(organizations.size() > 1) {
                        LOGGER.warn("There are " + organizations.size() + " results for the given information. (orgName=" + orgName + ")");
                    }
                    Organization organization = organizations.get(0);

                    List<RoleType> roleTypes = roleTypeRepository.findByRoleName(roleName);
                    if(roleTypes == null || roleTypes.isEmpty()) {
                        LOGGER.warn("There is no RoleType for the given information. (roleName=" + roleName + ")");
                        continue;
                    } else if(roleTypes.size() > 1) {
                        LOGGER.warn("There are " + roleTypes.size() + " results for the given information. (roleName=" + roleName + ")");
                    }
                    RoleType roleType = roleTypes.get(0);

                    YouthOrg youthOrg = new YouthOrg();
                    youthOrg.setYouth(youth);
                    youthOrg.setOrganization(organization);
                    youthOrg.setRoleType(roleType);
                    youthOrg.setStartDate(DateUtility.getFirstDay(Integer.valueOf(appliedYear)));
                    youthOrg.setEndDate(DateUtility.getLastDay(Integer.valueOf(appliedYear)));
                    model.addAttribute("youthOrg", youthOrg);
                    YouthOrg saveResult = youthOrgRepository.save(youthOrg);
                    model.addAttribute("youthOrgId", saveResult.getYouthOrgId());
                    model.addAttribute("success", youthOrg.equals(saveResult));
                }
            } catch (Exception e) {
                LOGGER.error("An error occurred while build YouthOrg information: " + e.getMessage());
            }
        }
        return "youthOrg/youthOrgInsertFileResult";
    }
    
}
