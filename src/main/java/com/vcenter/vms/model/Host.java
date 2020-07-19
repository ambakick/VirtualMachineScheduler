package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Entity
@Table (name = "Host")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostID;

    @Column(name = "hostname")
    private String hostName;
    private boolean standalone;
    private int clusterID;
    @Column(name = "cpucores")
    private int cpuCores;
    @Column(name = "memresource")
    private int memResource;
    @Column(name = "allottedcores")
    private int allottedCores;
    @Column(name = "allottedmem")
    private int allottedMem;
}
