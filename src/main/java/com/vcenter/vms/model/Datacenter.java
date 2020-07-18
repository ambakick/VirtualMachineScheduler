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
public class Datacenter {

    @Id
    @GeneratedValue
    private Long datacenterID;

    @Column(name = "datacentername")
    private String datacenterName;
    private int noOfClusters;
    private int noOfHosts;
    private int noOfVms;

}
