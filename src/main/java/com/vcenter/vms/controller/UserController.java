package com.vcenter.vms.controller;

import com.vcenter.vms.model.*;
import com.vcenter.vms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DatacenterService datacenterService;

    @Autowired
    private ClusterService clusterService;

    @Autowired
    private HostService hostService;

    @Autowired
    private VirtualMachineService vmService;

    @PostMapping(path="/user/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String roleType, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setUsername(name);
        n.setRoleType(roleType);
        n.setPassword(password);
        return "Saved";
    }

    @GetMapping(path = "/user/{userID}")
    public @ResponseBody
    User userById (@PathVariable Integer userID) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.findById(userID);
    }


    /** Datacenter
     *
     */
    @GetMapping(path = "/datacenter/{datacenterID}")
    public @ResponseBody
    Datacenter datacenterByID (@PathVariable Integer datacenterID){
        return datacenterService.findById(datacenterID);
    }

    //returns the list of Cluster Objects of that Datacenter
    @GetMapping(path = "/datacenter/getclusters/{datacenterID}")
    public @ResponseBody
    List<Cluster> clustersInDatacenter (@PathVariable Integer datacenterID){
        return clusterService.clustersInDatacenter(datacenterID);
    }

    @GetMapping(path = "/datacenter/aggregatedata/{datacenterID}")
    public @ResponseBody
    Summary aggregation (@PathVariable Integer datacenterID){

        return datacenterService.aggregation(datacenterID);
    }


    /**
     * CLUSTER level APIs
     */

    //returns cluster object
    @GetMapping(path = "/cluster/{clusterID}")
    public @ResponseBody
    Cluster clusterByID (@PathVariable Integer clusterID){
        return clusterService.findById(clusterID);
    }

    //returns Host objects beIntegering to the cluster
    @GetMapping(path = "/cluster/gethosts/{clusterID}")
    public @ResponseBody
    List<Host> hostsinCluster (@PathVariable Integer clusterID){
        return hostService.hostsInCluster(clusterID);
    }

    @GetMapping(path = "/cluster/aggregatedata/{clusterID}")
    public @ResponseBody
    Summary clusterAggregation (@PathVariable Integer clusterID){

        return clusterService.aggregation(clusterID);
    }


    /**
     * HOST level APIs
     */

    //returns the details of the host
    @GetMapping(path = "/host/{hostID}")
    public @ResponseBody
    Host hostByID (@PathVariable Integer hostID){
        return hostService.findById(hostID);
    }

    //returns the VMs objects belogning to the Host
    @GetMapping(path = "/host/getvms/{hostID}")
    public @ResponseBody
    List<VirtualMachine> vmsInHost (@PathVariable Integer hostID){
        return vmService.vmsInHost(hostID);
    }

    /**
     * VM level APIs
     */

    //returns VM details
    @GetMapping(path = "/vm/{vmID}")
    public @ResponseBody
    VirtualMachine vmByID (@PathVariable Integer vmID){

        return vmService.findById(vmID);
    }
}
