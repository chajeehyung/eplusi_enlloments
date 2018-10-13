package dk.eplusi.dev.enrollments.controller;

import dk.eplusi.dev.enrollments.common.DateUtility;
import dk.eplusi.dev.enrollments.model.code.ReligionType;
import dk.eplusi.dev.enrollments.model.eplusi.Youth;
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

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Gyummy on 2017-08-10.
 *
 */
@Controller
public class YouthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(YouthController.class);

    private static final List<String> PEER_LIST = new ArrayList<>();
    static {
        for(int i = 0; i < 100; i++) {
            String s;
            if(i < 10)
                s = "0" + i;
            else
                s = String.valueOf(i);
            PEER_LIST.add(s);
        }
    }

    private static final Map<String, String> KEYWORD_MAP = new LinkedHashMap<>();
    static {
        KEYWORD_MAP.put("youthName", "청년 이름");
        KEYWORD_MAP.put("youthPeer", "청년 또래");
        KEYWORD_MAP.put("cellPhone", "핸드폰 번호");
        KEYWORD_MAP.put("religionType", "신급");
    }

    private <T> T getOptionalValue(Optional<T> optional) {
        return optional.orElse(null);
    }

    private Youth setYouthInformation (Youth youth, HttpServletRequest request) throws ParseException {
        //essential
        youth.setYouthName(request.getParameter("youthName"));
        youth.setYouthPeer(request.getParameter("youthPeer"));
        String cellPhone = request.getParameter("cellPhone1") + request.getParameter("cellPhone2") + request.getParameter("cellPhone3");
        youth.setCellPhone(cellPhone);
        //optional
        String gender = request.getParameter("gender");
        if(gender != null)
            youth.setGender(gender.charAt(0));
        String birthDate = request.getParameter("birthDate");
        if(birthDate != null && !birthDate.isEmpty())
            youth.setBirthDate(DateUtility.parse(birthDate));
        String homeAddress = request.getParameter("homeAddress");
        if(homeAddress != null && !homeAddress.isEmpty())
            youth.setHomeAddress(homeAddress);
        String isBornChrParam = request.getParameter("isBornChr");
        if(isBornChrParam != null)
            youth.setIsBornChr(Integer.valueOf(isBornChrParam));
        else
            youth.setIsBornChr(-1);
        String isSelfInParam = request.getParameter("isSelfIn");
        if(isSelfInParam != null)
            youth.setIsSelfIn(Integer.valueOf(isSelfInParam));
        else
            youth.setIsSelfIn(-1);
        String guideName = request.getParameter("guideName");
        if(guideName != null && !guideName.isEmpty())
            youth.setGuideName(guideName);
        String occType = request.getParameter("occType");
        if(occType != null && !occType.isEmpty())
            youth.setOccType(getOptionalValue(occTypeRepository.findById(Integer.valueOf(occType))));
        String occ = request.getParameter("occ");
        if(occ != null && !occ.isEmpty())
            youth.setOcc(getOptionalValue(occRepository.findById(Integer.valueOf(occ))));
        String bizType = request.getParameter("bizType");
        if(bizType != null && !bizType.isEmpty())
            youth.setBizType(getOptionalValue(bizTypeRepository.findById(Integer.valueOf(bizType))));
        String religionType = request.getParameter("religionType");
        if(religionType != null && !religionType.isEmpty())
            youth.setReligionType(getOptionalValue(religionTypeRepository.findById(Integer.valueOf(religionType))));
        String churchRegDate = request.getParameter("churchRegDate");
        if(churchRegDate != null && !churchRegDate.isEmpty())
            youth.setChurchRegDate(DateUtility.parse(churchRegDate));
        String isAttendingParam = request.getParameter("isAttending");
        if(isAttendingParam != null)
            youth.setIsAttending(Integer.valueOf(isAttendingParam));
        else
            youth.setIsAttending(-1);
        String isRegisteredParam = request.getParameter("isRegistered");
        if(isRegisteredParam != null)
            youth.setIsRegistered(Integer.valueOf(isRegisteredParam));
        else
            youth.setIsRegistered(-1);
        youth.setUpdateTime(DateUtility.getToday());

        return youth;
    }

    private final YouthRepository youthRepository;
    private final OccTypeRepository occTypeRepository;
    private final OccRepository occRepository;
    private final BizTypeRepository bizTypeRepository;
    private final ReligionTypeRepository religionTypeRepository;

    @Autowired
    public YouthController(YouthRepository youthRepository, OccTypeRepository occTypeRepository, OccRepository occRepository, BizTypeRepository bizTypeRepository, ReligionTypeRepository religionTypeRepository) {
        this.youthRepository = youthRepository;
        this.occTypeRepository = occTypeRepository;
        this.occRepository = occRepository;
        this.bizTypeRepository = bizTypeRepository;
        this.religionTypeRepository = religionTypeRepository;
    }

    @GetMapping(value = "youthInsert")
    public String youthInsert(Model model) {
        model.addAttribute("peerList", PEER_LIST);
        model.addAttribute("occTypeList", occTypeRepository.findAll());
        model.addAttribute("occList", occRepository.findAll());
        model.addAttribute("bizTypeList", bizTypeRepository.findAll());
        model.addAttribute("religionTypeList", religionTypeRepository.findAll());

        return "youth/youthInsert";
    }

    @PostMapping(value = "youthInsertResult")
    public String youthInsertResult(HttpServletRequest request, Model model) {
        try {
            Youth youth = setYouthInformation(new Youth(), request);
            model.addAttribute("youth", youth);
            Youth saveResult = youthRepository.save(youth);
            model.addAttribute("youthId", saveResult.getYouthId());
            model.addAttribute("success", youth.equals(saveResult));
        } catch (ParseException e) {
            model.addAttribute("errorMsg", "날짜 형식이 필요한 값을 잘못 입력하였습니다.");
        }
        return "youth/youthInsertResult";
    }

    @PostMapping(value = "youthModify")
    public String youthModify(HttpServletRequest request, Model model) {
        Integer youthId = Integer.valueOf(request.getParameter("youthId"));
        Optional<Youth> result = youthRepository.findById(youthId);
        if(result.isPresent()) {
            Youth youth = result.get();
            model.addAttribute("youth", youth);
            model.addAttribute("peerList", PEER_LIST);

            List<Map<String, Object>> occTypeList = new ArrayList<>();
            occTypeRepository.findAll().forEach(occType -> {
                Map<String, Object> occTypeMap = new HashMap<>();
                occTypeMap.put("key", occType.getOccTypeCode());
                occTypeMap.put("value", occType.getOccType());
                if(occType.equals(youth.getOccType()))
                    occTypeMap.put("selected", true);
                occTypeList.add(occTypeMap);
            });
            model.addAttribute("occTypeList", occTypeList);

            List<Map<String, Object>> occList = new ArrayList<>();
            occRepository.findAll().forEach(occ -> {
                Map<String, Object> occMap = new HashMap<>();
                occMap.put("key", occ.getOccCode());
                occMap.put("value", occ.getOccName());
                if(occ.equals(youth.getOcc()))
                    occMap.put("selected", true);
                occList.add(occMap);
            });
            model.addAttribute("occList", occList);

            List<Map<String, Object>> bizTypeList = new ArrayList<>();
            bizTypeRepository.findAll().forEach(bizType -> {
                Map<String, Object> bizTypeMap = new HashMap<>();
                bizTypeMap.put("key", bizType.getBizTypeCode());
                bizTypeMap.put("value", bizType.getBizType());
                if(bizType.equals(youth.getBizType()))
                    bizTypeMap.put("selected", true);
                bizTypeList.add(bizTypeMap);
            });
            model.addAttribute("bizTypeList", bizTypeList);

            List<Map<String, Object>> religionTypeList = new ArrayList<>();
            religionTypeRepository.findAll().forEach(religionType -> {
                Map<String, Object> religionTypeMap = new HashMap<>();
                religionTypeMap.put("key", religionType.getReligionTypeCode());
                religionTypeMap.put("value", religionType.getReligionType());
                if(religionType.equals(youth.getReligionType()))
                    religionTypeMap.put("selected", true);
                religionTypeList.add(religionTypeMap);
            });
            model.addAttribute("religionTypeList", religionTypeList);
        }

        return "youth/youthModify";
    }

    @PostMapping(value = "youthModifyResult")
    public String youthModifyResult(HttpServletRequest request, Model model) {
        try {
            Integer youthId = Integer.valueOf(request.getParameter("youthId"));
            Optional<Youth> result = youthRepository.findById(youthId);
            if (result.isPresent()) {
                Youth youth = setYouthInformation(result.get(), request);
                model.addAttribute("youth", youth);
                Youth saveResult = youthRepository.save(youth);
                model.addAttribute("success", youth.equals(saveResult));
            }
        } catch (ParseException e) {
            model.addAttribute("errorMsg", "날짜 형식이 필요한 값을 잘못 입력하였습니다.");
        }
        return "youth/youthModifyResult";
    }

    @GetMapping(value = "youthDetail")
    public String youthDetail(HttpServletRequest request, Model model) {
        Integer youthId = Integer.valueOf(request.getParameter("youthId"));
        Optional<Youth> result = youthRepository.findById(youthId);
        model.addAttribute("found", result.isPresent());
        if(result.isPresent()) {
            Youth youth = result.get();
            model.addAttribute("youth", youth);
        }
        return "youth/youthDetail";
    }

    // 페이징 제거
    @GetMapping(value = "/youthSearch")
    public String youthSearchGet(HttpServletRequest request, Model model) {
        return youthSearchPost(request, model);
    }

    // 페이징 제거
    @PostMapping(value = "/youthSearch")
    public String youthSearchPost(HttpServletRequest request, Model model) {
        List<Youth> result = null;
        String target = request.getParameter("target");
        String keyword = request.getParameter("keyword");
        model.addAttribute("target", target);
        model.addAttribute("keyword", keyword);
        if (target != null && !target.isEmpty() && keyword != null && !keyword.isEmpty()) {
            switch (target) {
                case "youthName":
                    result = youthRepository.findByYouthName(keyword);
                    break;
                case "youthPeer":
                    result = youthRepository.findByYouthPeer(keyword);
                    break;
                case "cellPhone":
                    result = youthRepository.findByCellPhone(keyword);
                    break;
                case "religionType":
                    List<ReligionType> searchedReligionTypeList = religionTypeRepository.findByReligionType(keyword);
                    if(!searchedReligionTypeList.isEmpty())
                        result = youthRepository.findByReligionType(searchedReligionTypeList.get(0));
                    break;
            }
        }

        if(result == null)
            result = youthRepository.findAll();

        model.addAttribute("size", result.size());
        model.addAttribute("youths", result.iterator());
        model.addAttribute("keywordMap", KEYWORD_MAP);

       /* List<Integer> pageNumbers = new ArrayList<>();
        for(int i = 0; i < result.getTotalPages(); i++)
            pageNumbers.add(i);
        model.addAttribute("pageNumbers", pageNumbers);*/

        return "youth/youthSearch";
    }

    //TODO batch delete 구현 필요
    @PostMapping(value = "/youthDeleteResult")
    public String youthDeleteResult(HttpServletRequest request, Model model) {
        List<String> deletedNames = new ArrayList<>();
        String[] youthIds = request.getParameterValues("youthId");

        if (youthIds != null && youthIds.length > 0) {
            for (String youthIdStr : youthIds) {
                Integer youthId = Integer.valueOf(youthIdStr);
                Optional<Youth> result = youthRepository.findById(youthId);
                if (result.isPresent()) {
                    Youth youth = result.get();
                    youthRepository.delete(youth);
                    deletedNames.add(youth.getYouthName());
                }
            }
            int diff = youthIds.length - deletedNames.size();
            if(diff > 0)
                model.addAttribute("errorMsg", diff + "개의 청년 정보는 삭제할 수 없습니다.");
        } else {
            model.addAttribute("errorMsg", "삭제 요청이 올바르지 않습니다.");
        }
        model.addAttribute("deletedNames", deletedNames);
        return "youth/youthDeleteResult";
    }
}
