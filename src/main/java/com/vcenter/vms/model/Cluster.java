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
public class Cluster {

    @Id
    @GeneratedValue
    private Long clusterID;
    @Column(name = "clustername")
    private String clusterName;
    private Long datacenterID;

}
