package com.vcenter.vms.repository;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends CrudRepository<Host, Long> {

    @Query("select count(*) from Host where ClusterID = :clusterID")
    int countHostsInCluster(@Param("clusterID") Long clusterID);

    @Query("select hostID from Host where clusterID = :clusterID")
    List<Integer> listHostsInCluster(@Param("clusterID") Long clusterID);

    @Query("select h from Host h where h.clusterID = :clusterID")
    List<Host> hostsInCluster(@Param("clusterID") Long clusterID);
}