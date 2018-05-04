package io.pivotal.actuatordemo.repository;

import io.pivotal.actuatordemo.domain.LearnDay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnDayRepository extends CrudRepository<LearnDay, Long> {
}
