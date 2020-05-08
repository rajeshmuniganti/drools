package com.atmecs.ep.repository;

import com.atmecs.ep.model.TimeSheet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Repository
@Transactional
@EnableJpaAuditing
public interface TimeSheetRepository extends CrudRepository<TimeSheet, Serializable> {

    public Set<TimeSheet> findByemail(@NotNull final String email);

    @Modifying
    @Query("UPDATE TimeSheet t SET t.payStatus = :payStatus WHERE t.weekNumber = :weekNumber AND t.email=:email")
    int updateTimeSheet(@Param("email") String email, @Param("weekNumber") Integer weekNumber,
                        @Param("payStatus") String payStatus);

}
