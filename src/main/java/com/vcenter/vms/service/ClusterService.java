package com.vcenter.vms.service;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.Summary;
import com.vcenter.vms.repository.ClusterRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClusterService implements ClusterServiceInterface {
    @Autowired
    private ClusterRepository clusterRepository;

    @Autowired
    private HostService hostService;

    public List<Cluster> findAll() {

        return (List<Cluster>) clusterRepository.findAll();
    }

    public Cluster findById(Integer clusterID) {

        List<Cluster> clusters = findAll();
        Cluster clusterObj = null;
        Summary summary = aggregation(clusterID);
        for(Cluster cluster : clusters) {
            if (cluster.getClusterID() == clusterID){
                clusterObj = cluster;
                break;
            }
        }
        clusterObj.setNoOfHosts(summary.getNoOfHosts());
        clusterObj.setNoOfVms(summary.getNoOfHosts());
        clusterRepository.save(clusterObj);
        return clusterObj;
    }

    public List<Cluster> clustersInDatacenter(Integer datacenterID) {

        return clusterRepository.clustersInDatacenter(datacenterID);
    }

    public int deleteById(Integer clusterID) {

        List<Host> listOfHosts = hostService.hostsInCluster(clusterID);
        for(Host host:listOfHosts){
            hostService.deleteById(host.getHostID());
        }
        clusterRepository.deleteById(clusterID);
        return listOfHosts.size();
    }

    public Summary aggregation(Integer clusterId){
        return clusterRepository.aggregation(clusterId);
    }

    public void save(Cluster cluster){
        clusterRepository.save(cluster);
    }
}
