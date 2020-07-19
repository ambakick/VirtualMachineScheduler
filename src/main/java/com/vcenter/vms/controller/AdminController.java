package com.vcenter.vms.controller;

import com.vcenter.vms.exception.ResourceNotAvailable;
import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Datacenter;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
public class AdminController {

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

    /**
     * DATACENTER level APIs
     * @param datacenter
     * @return
     */

    @PostMapping(path = "/datacenter")
    public Datacenter createDatacenter(@RequestBody Datacenter datacenter) {
        datacenter.setDatacenterID(0);
        datacenterService.save(datacenter);
        return  datacenter;
    }

    @PutMapping(path = "/datacenter")
    public Datacenter updateDatacenter(@RequestBody Datacenter datacenter) {
        datacenterService.save(datacenter);
        return datacenter;
    }

    //returns number of clusters deleted under the datacenter
    @GetMapping(path = "/datacenter/delete/{datacenterID}")
    public @ResponseBody
    int deleteDatacenterByID (@PathVariable Integer datacenterID){
        return datacenterService.deleteById(datacenterID);
    }


    /**
     * CLUSTER level APIs
     */

    @PostMapping(path = "/cluster")
    public Cluster createCluster(@RequestBody Cluster cluster) {
        cluster.setClusterID(0);
        clusterService.save(cluster);
        return  cluster;
    }

    @PutMapping(path = "/cluster")
    public Cluster updateCluster(@RequestBody Cluster cluster) {
        clusterService.save(cluster);
        return cluster;
    }

    //returns number of hosts deleted under the cluster
    @GetMapping(path = "/cluster/delete/{clusterID}")
    public @ResponseBody
    int deleteClusterbyID (@PathVariable Integer clusterID){

        return clusterService.deleteById(clusterID);
    }

    /**
     * HOST level APIs
     */

    @PostMapping(path = "/host")
    public Host createHost(@RequestBody Host host) {
        host.setHostID(0);
        hostService.save(host);
        return  host;
    }

    @PutMapping(path = "/host")
    public Host updateHost(@RequestBody Host host) {
        hostService.save(host);
        return host;
    }

    //returns the number of VMs deleted under the host
    @GetMapping(path = "/host/delete/{hostID}")
    public @ResponseBody
    int deleteHostById (@PathVariable Integer hostID){

        return hostService.deleteById(hostID);
    }


    /**
     * VM level APIs
     */

    //delete a VM given vmID
    @GetMapping(path = "/vm/delete/{vmID}")
    public @ResponseBody
    void deleteVmByID (@PathVariable Integer vmID){
        vmService.deleteById(vmID);
    }

    @PostMapping(path = "/vm/athost")
    public ResponseEntity<VirtualMachine> createVM(@RequestBody VirtualMachine vm) {
        vm.setVmID(0);
        Host host = hostService.findById(vm.getHostID());
        int newAllottedCores = host.getAllottedCores() + vm.getCpuCores();
        int newAllottedMem = host.getAllottedMem() + vm.getMemResource();
        if((newAllottedCores <= host.getCpuCores()) && (newAllottedMem <= host.getMemResource())){
            vmService.save(vm);
            host.setAllottedCores(newAllottedCores);
            host.setAllottedMem(newAllottedMem);
            hostService.save(host);
        }
        else{
            throw new ResourceNotAvailable("Resource not available");
        }
        return ResponseEntity.ok(vm);
    }

    @PutMapping(path = "/vm")
    public VirtualMachine updateVM(@RequestBody VirtualMachine vm) {
        vmService.save(vm);
        return vm;
    }
}
