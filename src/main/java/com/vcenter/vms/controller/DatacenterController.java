package com.vcenter.vms.controller;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Datacenter;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.service.ClusterService;
import com.vcenter.vms.service.DatacenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatacenterController {
    @Autowired
    DatacenterService datacenterService;

    @Autowired
    ClusterService clusterService;

    @GetMapping(path = "/datacenter/{datacenterID}")
    public @ResponseBody
    Datacenter datacenterByID (@PathVariable Long datacenterID){
        return datacenterService.findById(datacenterID);
    }


    @GetMapping(path = "/datacenter/{datacenterID}/cluster_ids/")
    public @ResponseBody
    List<Integer> listVmsInHost (@PathVariable Long datacenterID){
        return clusterService.listClusterInDatacenter(datacenterID);
    }

    @GetMapping(path = "/datacenter/{datacenterID}/clusters/")
    public @ResponseBody
    List<Cluster> vmsInHost (@PathVariable Long datacenterID){
        return clusterService.clustersInDatacenter(datacenterID);
    }
}
