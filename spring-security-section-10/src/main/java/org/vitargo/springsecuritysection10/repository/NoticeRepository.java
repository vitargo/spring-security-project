package org.vitargo.springsecuritysection10.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection10.model.Notice;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query(value = "from Notice n where current_date BETWEEN noticBegDt AND noticEndDt")
    List<Notice> findAllActiveNotices();

}
