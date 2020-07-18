package com.vcenter.vms.repository;

import com.vcenter.vms.model.Datacenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatacenterRepository extends CrudRepository<Datacenter, Long> {

}
