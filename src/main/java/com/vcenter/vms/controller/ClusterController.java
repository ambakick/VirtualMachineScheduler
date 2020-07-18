package com.vcenter.vms.controller;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.service.ClusterService;
import com.vcenter.vms.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClusterController {
    @Autowired
    ClusterService clusterService;

    @Autowired
    HostService hostService;

    @GetMapping(path = "/cluster/{clusterID}")
    public @ResponseBody
    Cluster clusterByID (@PathVariable Long clusterID){
        return clusterService.findById(clusterID);
    }

    @GetMapping(path = "/cluster/{clusterID}/host_ids/")
    public @ResponseBody
    List<Integer> listVmsInHost (@PathVariable Long clusterID){
        return hostService.listHostsInCluster(clusterID);
    }

    @GetMapping(path = "/cluster/{clusterID}/hosts/")
    public @ResponseBody
    List<Host> vmsInHost (@PathVariable Long clusterID){
        return hostService.hostsInCluster(clusterID);
    }
}
