package com.vcenter.vms.service;

import com.vcenter.vms.model.Host;

import java.util.List;

public interface HostServiceInterface {

    List<Host> findAll();
    Host findById (Integer hostID);
    List<Host> hostsInCluster(Integer clusterID);
    void updateHostOnDeletion(Integer hostID, int coresReleased, int memReleased);
    void save(Host host);
    int deleteById(Integer hostID);
}
