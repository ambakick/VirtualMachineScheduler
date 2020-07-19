package com.vcenter.vms.service;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService implements HostServiceInterface{

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private VirtualMachineService vmService;

    public List<Host> findAll(){

        return (List<Host>) hostRepository.findAll();
    }

    public Host findById (Integer hostID){
        List<Host> hosts = findAll();

        for(Host host : hosts) {
            if (host.getHostID() == hostID)
                return host;
        }

        return null;
    }

    public List<Host> hostsInCluster(Integer clusterID) {

        return hostRepository.hostsInCluster(clusterID);
    }

    public void updateHostOnDeletion(Integer hostID, int coresReleased, int memReleased){

        Host host = findById(hostID);
        int allocatedCores = host.getAllottedCores() - coresReleased;
        int allocatedMem = host.getAllottedMem() - memReleased;
        hostRepository.updateAllocatedData(hostID, allocatedCores, allocatedMem);
    }

    public int deleteById(Integer hostID) {
        int deletedVMs = vmService.deleteVmsInHost(hostID);
        hostRepository.deleteById(hostID);
        return deletedVMs;
    }

    public void save (Host host){
        hostRepository.save(host);
    }
}
