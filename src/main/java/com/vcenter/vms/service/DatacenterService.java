package com.vcenter.vms.service;

import com.vcenter.vms.model.Datacenter;
import com.vcenter.vms.repository.DatacenterRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatacenterService {
    @Autowired
    private DatacenterRepository datacenterRepository;

    public List<Datacenter> findAll() {

        var it = datacenterRepository.findAll();

        var dataCenters = new ArrayList<Datacenter>();
        it.forEach(e -> dataCenters.add(e));

        return dataCenters;
    }

    public Datacenter findById(Long datacenterID) {

        List<Datacenter> datacenters = findAll();

        for(Datacenter datacenter : datacenters) {
            if (datacenter.getDatacenterID().equals(datacenterID))
                return datacenter;
        }

        return null;
    }

    public Long count() {

        return datacenterRepository.count();
    }

    public void deleteById(Long userId) {

        datacenterRepository.deleteById(userId);
    }
}
