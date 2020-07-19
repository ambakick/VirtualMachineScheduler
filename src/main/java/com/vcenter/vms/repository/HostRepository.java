package com.vcenter.vms.repository;

import com.vcenter.vms.model.Host;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HostRepository extends CrudRepository<Host, Integer> {

    @Query("select h from Host h where h.clusterID = :clusterID")
    List<Host> hostsInCluster(@Param("clusterID") Integer clusterID);

    @Transactional
    @Modifying
    @Query("delete from Host h where h.clusterID = :clusterID")
    int deleteHostsPerCluster(@Param("clusterID") Integer clusterID);

    @Transactional
    @Modifying
    @Query("update Host set allottedcores = :allottedcores, allottedmem = :allottedmem where hostID = :hostID")
    void updateAllocatedData(@Param("hostID") Integer hostID, @Param("allottedcores") int allottedCores, @Param("allottedmem") int allottedMem);

}