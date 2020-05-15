package com.project.kolaybpm.service;

import com.project.kolaybpm.model.WatchProcess;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatchProcessService {

    public List<WatchProcess> getAll();
}
