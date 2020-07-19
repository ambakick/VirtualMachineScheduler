package com.vcenter.vms.repository;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.Summary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ClusterRepository extends CrudRepository<Cluster, Integer> {

    @Query("select clusterID from Cluster where datacenterID = :datacenterID")
    List<Integer> listClustersInDatacenter(@Param("datacenterID") Integer datacenterID);

    @Query("select c from Cluster c where c.datacenterID = :datacenterID")
    List<Cluster> clustersInDatacenter(@Param("datacenterID") Integer datacenterID);

    @Transactional
    @Modifying
    @Query("delete from Cluster c where c.datacenterID = :datacenterID")
    int deleteClusterPerDc(@Param("datacenterID") Integer datacenterID);

    @Query("select new com.vcenter.vms.model.Summary(COUNT(distinct h.hostID ), COUNT(distinct vm.vmID)) " +
            "from Cluster c " +
            "inner join Host h on c.clusterID = h.clusterID " +
            "inner join virtualmachine vm on vm.hostID = h.hostID " +
            "where c.clusterID = :clusterID")
    Summary aggregation(@Param("clusterID") Integer clusterID);
}
