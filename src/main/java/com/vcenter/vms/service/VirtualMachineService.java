package com.vcenter.vms.service;

import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.repository.VirtualMachineRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirtualMachineService implements VirtualMachineServiceInterface {
    @Autowired
    private VirtualMachineRepository vmRepo;

    @Autowired
    private HostService hostService;


    public List<VirtualMachine> findAll() {

        return (List<VirtualMachine>) vmRepo.findAll();
    }

    public VirtualMachine findById(Integer vmID) {

        List<VirtualMachine> vms = findAll();

        for(VirtualMachine vm : vms) {
            if (vm.getVmID() == vmID)
                return vm;
        }
        return null;
    }

    public List<VirtualMachine> vmsInHost(Integer hostID) {
        return vmRepo.vmsInHost(hostID);
    }

    public void deleteById(Integer vmID) {
        updateHostOnDeletion(vmID);
        vmRepo.deleteById(vmID);
    }

    public void updateHostOnDeletion(Integer vmID){

        VirtualMachine virtualMachine = findById(vmID);
        int coresReleased = virtualMachine.getCpuCores();
        int memReleased = virtualMachine.getMemResource();
        hostService.updateHostOnDeletion(virtualMachine.getHostID(), coresReleased, memReleased);
    }

    public void updateHost(Integer vmID, int newCpuCores, int newMem){

        VirtualMachine virtualMachine = findById(vmID);
        int coresReleased = virtualMachine.getCpuCores();
        int memReleased = virtualMachine.getMemResource();
        hostService.updateHostOnDeletion(virtualMachine.getHostID(), coresReleased, memReleased);
    }

    public int deleteVmsInHost(Integer hostID){
        return vmRepo.deleteVmsInHost(hostID);
    }

    public void save (VirtualMachine virtualMachine){
        vmRepo.save(virtualMachine);
    }
}
