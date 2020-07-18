package com.vcenter.vms.service;

import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.repository.VirtualMachineRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirtualMachineService {
    @Autowired
    private VirtualMachineRepository vmRepo;

    public List<VirtualMachine> findAll() {

        var it = vmRepo.findAll();

        var vms = new ArrayList<VirtualMachine>();
        it.forEach(e -> vms.add(e));

        return vms;
    }

    public VirtualMachine findById(Long userID) {

        List<VirtualMachine> vms = findAll();

        for(VirtualMachine vm : vms) {
            if (vm.getVmID().equals(userID))
                return vm;
        }

        return null;
    }

    public int countVmsInHost(Long hostID){
        return vmRepo.countVmsInHost(hostID);
    }


    public List<Integer> listVmsInHost(Long hostID) {
        return vmRepo.listVmsInHost(hostID);
    }

    public List<VirtualMachine> vmsInHost(Long hostID) {
        return vmRepo.vmsInHost(hostID);
    }

    public Long count() {

        return vmRepo.count();
    }

    public void deleteById(Long userId) {

        vmRepo.deleteById(userId);
    }
}
