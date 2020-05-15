package com.project.kolaybpm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchProcess")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WatchProcess {

    @Id
    @GeneratedValue
    private Long recordId;

    private String taskId;

    private String processId;

    private String executionId;

}
