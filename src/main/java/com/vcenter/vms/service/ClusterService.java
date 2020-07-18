package com.vcenter.vms.service;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.repository.ClusterRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClusterService {
    @Autowired
    private ClusterRepository clusterRepository;

    public List<Cluster> findAll() {

        var it = clusterRepository.findAll();

        var users = new ArrayList<Cluster>();
        it.forEach(e -> users.add(e));

        return users;
    }

    public Cluster findById(Long userID) {

        List<Cluster> clusters = findAll();

        for(Cluster cluster : clusters) {
            if (cluster.getClusterID().equals(userID))
                return cluster;
        }

        return null;
    }

    public int countClusterInDatacenter (Long datacenterID){

        return clusterRepository.countClustersInDatacenter(datacenterID);
    }

    public List<Integer> listClusterInDatacenter(Long datacenterID) {

        return clusterRepository.listClustersInDatacenter(datacenterID);
    }

    public List<Cluster> clustersInDatacenter(Long datacenterID) {

        return clusterRepository.clustersInDatacenter(datacenterID);
    }

    public Long count() {

        return clusterRepository.count();
    }

    public void deleteById(Long userId) {

        clusterRepository.deleteById(userId);
    }
}
