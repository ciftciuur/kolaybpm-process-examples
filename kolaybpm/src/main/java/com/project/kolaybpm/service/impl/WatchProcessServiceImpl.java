package com.project.kolaybpm.service.impl;

import com.project.kolaybpm.dao.WatchProcessRepository;
import com.project.kolaybpm.model.WatchProcess;
import com.project.kolaybpm.service.WatchProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchProcessServiceImpl implements WatchProcessService {

    @Autowired
    private WatchProcessRepository watchProcessRepository;


    @Override
    public List<WatchProcess> getAll() {
        return (List<WatchProcess>) watchProcessRepository.findAll();
    }
}
