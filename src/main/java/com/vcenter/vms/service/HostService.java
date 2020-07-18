package com.vcenter.vms.service;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;
import com.vcenter.vms.repository.HostRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public List<Host> findAll(){

        var it = hostRepository.findAll();

        var hosts = new ArrayList<Host>();
        it.forEach(e -> hosts.add(e));

        return hosts;
    }

    public Host findById (Long hostID){
        List<Host> hosts = findAll();

        for(Host host : hosts) {
            if (host.getHostID().equals(hostID))
                return host;
        }

        return null;
    }

    public int countHostsInCluster (Long clusterID){

        return hostRepository.countHostsInCluster(clusterID);
    }

    public List<Integer> listHostsInCluster(Long clusterID) {

        return hostRepository.listHostsInCluster(clusterID);
    }

    public List<Host> hostsInCluster(Long clusterID) {

        return hostRepository.hostsInCluster(clusterID);
    }


    public Long count() {

        return hostRepository.count();
    }

    public void deleteById(Long userId) {

        hostRepository.deleteById(userId);
    }
}
