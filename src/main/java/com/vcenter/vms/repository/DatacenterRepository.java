package com.vcenter.vms.repository;

import com.vcenter.vms.model.Datacenter;
import com.vcenter.vms.model.Summary;
import com.vcenter.vms.model.VirtualMachine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DatacenterRepository extends CrudRepository<Datacenter, Integer> {

    @Transactional
    @Modifying
    @Query("update Datacenter set noofclusters = :noofclusters")
    void updateClusterCount(@Param("noofclusters") Integer noofclusters);

    @Transactional
    @Modifying
    @Query("update Datacenter set noofhosts = :noofhosts")
    void updateHostCount(@Param("noofhosts") Integer noofhosts);

    @Transactional
    @Modifying
    @Query("update Datacenter set noofvms = :noofvms")
    void updateVMCount(@Param("noofvms") Integer noofvms);

    @Query("select new com.vcenter.vms.model.Summary(COUNT(distinct c.clusterID ), COUNT(distinct h.hostID ), COUNT(distinct vm.vmID)) " +
            "from Datacenter d inner join Cluster c on d.datacenterID = c.datacenterID " +
            "inner join Host h on c.clusterID = h.clusterID " +
            "inner join virtualmachine vm on vm.hostID = h.hostID " +
            "where d.datacenterID = :datacenterID")
    Summary aggregation(@Param("datacenterID") Integer datacenterID);

}

