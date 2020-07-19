package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Data
@Entity
@Table (name = "Cluster")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Cluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clusterID;
    @Column(name = "clustername")
    private String clusterName;
    private int datacenterID;

    @Column(name = "noOfHosts")
    private int noOfHosts;
    @Column(name = "noOfVms")
    private int noOfVms;
}
