package com.vcenter.vms.controller;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.service.HostService;
import com.vcenter.vms.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    HostService hostService;

    @Autowired
    VirtualMachineService vmService;

    @GetMapping(path = "/host/{hostID}")
    public @ResponseBody
    Host hostByID (@PathVariable Long hostID){
        return hostService.findById(hostID);
    }

    @GetMapping(path = "/host/count/{clusterID}")
    public @ResponseBody
    int countHostsInCluster (@PathVariable Long clusterID){
        return hostService.countHostsInCluster(clusterID);
    }

    @GetMapping(path = "/host/{hostID}/vm_count/")
    public @ResponseBody
    int countVmsInHost (@PathVariable Long hostID){
        return vmService.countVmsInHost(hostID);
    }

    @GetMapping(path = "/host/{hostID}/vm_ids/")
    public @ResponseBody
    List<Integer> listVmsInHost (@PathVariable Long hostID){
        return vmService.listVmsInHost(hostID);
    }

    @GetMapping(path = "/host/{hostID}/vms/")
    public @ResponseBody
    List<VirtualMachine> vmsInHost (@PathVariable Long hostID){
        return vmService.vmsInHost(hostID);
    }


}
