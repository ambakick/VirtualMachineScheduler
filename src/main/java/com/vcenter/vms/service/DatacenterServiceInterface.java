package com.vcenter.vms.service;

import com.vcenter.vms.model.Datacenter;

import java.util.List;

public interface DatacenterServiceInterface {

    List<Datacenter> findAll();
    Datacenter findById(Integer datacenterID);
    int deleteById(Integer datacenterID);
    void save (Datacenter datacenter);
}
