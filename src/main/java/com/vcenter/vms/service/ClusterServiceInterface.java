package com.vcenter.vms.service;

import com.vcenter.vms.model.Cluster;

import java.util.List;

public interface ClusterServiceInterface {

    List<Cluster> findAll();
    Cluster findById(Integer userID);
    List<Cluster> clustersInDatacenter(Integer datacenterID);
    void save(Cluster cluster);
    int deleteById(Integer clusterID);
}



