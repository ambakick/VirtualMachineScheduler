package com.vcenter.vms.repository;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VirtualMachineRepository extends CrudRepository<VirtualMachine, Integer> {

    @Query("select vmID from virtualmachine where HostID = :hostID")
    List<Integer> listVmsInHost(@Param("hostID") Integer hostID);

    @Query("select vm from virtualmachine vm where vm.hostID = :hostID")
    List<VirtualMachine> vmsInHost(@Param("hostID") Integer hostID);

    @Transactional
    @Modifying
    @Query("delete from virtualmachine vm where vm.hostID = :hostID")
    int deleteVmsInHost(@Param("hostID") Integer hostID);
}
