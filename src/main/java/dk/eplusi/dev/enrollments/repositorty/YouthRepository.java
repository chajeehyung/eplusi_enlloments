package dk.eplusi.dev.enrollments.repositorty;

import dk.eplusi.dev.enrollments.model.code.ReligionType;
import dk.eplusi.dev.enrollments.model.eplusi.Youth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YouthRepository extends JpaRepository<Youth, Integer> {
    List<Youth> findByYouthName(String youthName);
    Page<Youth> findByYouthName(String youthName, Pageable pageable);

    List<Youth> findByYouthPeer(String youthPeer);
    Page<Youth> findByYouthPeer(String youthPeer, Pageable pageable);

    List<Youth> findByCellPhone(String cellPhone);
    Page<Youth> findByCellPhone(String cellPhone, Pageable pageable);

    List<Youth> findByReligionType(ReligionType religionType);
    Page<Youth> findByReligionType(ReligionType religionType, Pageable pageable);

    List<Youth> findByYouthNameAndYouthPeer(String youthName, String youthPeer);
}
