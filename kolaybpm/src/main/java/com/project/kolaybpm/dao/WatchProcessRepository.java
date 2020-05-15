package com.project.kolaybpm.dao;

import com.project.kolaybpm.model.WatchProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchProcessRepository extends CrudRepository<WatchProcess, Long> {
}
