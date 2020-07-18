package com.vcenter.vms.controller;

import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualMachineController {
    @Autowired
    VirtualMachineService vmService;

    @GetMapping(path = "/vm/{vmID}")
    public @ResponseBody
    VirtualMachine vmByID (@PathVariable Long vmID){
        return vmService.findById(vmID);
    }

}
