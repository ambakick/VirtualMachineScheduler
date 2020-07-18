package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Host {

    @Id
    @GeneratedValue
    private Long hostID;

    @Column(name = "hostname")
    private String hostName;
    private boolean standalone;
    private Long clusterID;
    @Column(name = "cpucount")
    private int cpuCount;
    @Column(name = "memresource")
    private int memResource;
}
