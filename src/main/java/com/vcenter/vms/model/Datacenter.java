package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Entity
@Table (name = "Datacenter")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Datacenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int datacenterID;

    @Column(name = "datacentername")
    private String datacenterName;
    @Column(name = "noofclusters")
    private int noOfClusters;
    @Column(name = "noofhosts")
    private int noOfHosts;
    @Column(name = "noofvms")
    private int noOfVms;

}
