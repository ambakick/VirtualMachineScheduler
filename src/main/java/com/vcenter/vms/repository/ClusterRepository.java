package com.vcenter.vms.repository;

import com.vcenter.vms.model.Cluster;
import com.vcenter.vms.model.Host;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClusterRepository extends CrudRepository<Cluster, Long> {
    @Query("select count(*) from Cluster where datacenterID = :datacenterID")
    int countClustersInDatacenter(@Param("datacenterID") Long datacenterID);

    @Query("select clusterID from Cluster where datacenterID = :datacenterID")
    List<Integer> listClustersInDatacenter(@Param("datacenterID") Long datacenterID);

    @Query("select c from Cluster c where c.datacenterID = :datacenterID")
    List<Cluster> clustersInDatacenter(@Param("datacenterID") Long datacenterID);
}
