package com.vcenter.vms.service;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Datacenter;
import com.vcenter.vms.model.Summary;
import com.vcenter.vms.repository.DatacenterRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatacenterService implements DatacenterServiceInterface {
    @Autowired
    private DatacenterRepository datacenterRepository;

    @Autowired
    private ClusterService clusterService;

    public List<Datacenter> findAll() {

        return (List<Datacenter>) datacenterRepository.findAll();
    }

    public Datacenter findById(Integer datacenterID) {

        List<Datacenter> datacenters = findAll();
        Datacenter datacenterObj = null;
        Summary summary = aggregation(datacenterID);
        for(Datacenter datacenter : datacenters) {
            if (datacenter.getDatacenterID() == datacenterID){
                datacenterObj = datacenter;
                break;
            }
        }
        datacenterObj.setNoOfClusters(summary.getNoOfClusters());
        datacenterObj.setNoOfHosts(summary.getNoOfClusters());
        datacenterObj.setNoOfVms(summary.getNoOfVms());
        datacenterRepository.save(datacenterObj);
        return datacenterObj;
    }

    public int deleteById(Integer datacenterID) {

        List<Cluster> listOfClusters = clusterService.clustersInDatacenter(datacenterID);
        for(Cluster cluster:listOfClusters){

            clusterService.deleteById(cluster.getClusterID());
        }
        datacenterRepository.deleteById(datacenterID);
        return listOfClusters.size();
    }

    public void save(Datacenter datacenter){
        datacenterRepository.save(datacenter);
    }

    public Summary aggregation(Integer datacenterID){
        return datacenterRepository.aggregation(datacenterID);
    }
}
