package com.vcenter.vms.service;

import com.vcenter.vms.model.VirtualMachine;

import java.util.List;

public interface VirtualMachineServiceInterface {

    List<VirtualMachine> findAll();
    VirtualMachine findById(Integer userID);
    List<VirtualMachine> vmsInHost(Integer hostID);
    void deleteById(Integer vmID);
    void updateHostOnDeletion(Integer vmID);
    void save(VirtualMachine virtualMachine);
    int deleteVmsInHost(Integer hostID);
}
