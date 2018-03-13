package co.bbs.module.code.repository;

import co.bbs.module.code.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomoya on 17-6-6.
 */
@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {

  List<Code> findByEmailAndCodeAndType(String email, String code, String type);

}
