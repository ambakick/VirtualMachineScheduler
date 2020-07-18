package com.vcenter.vms.repository;

import com.vcenter.vms.model.Host;
import com.vcenter.vms.model.VirtualMachine;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VirtualMachineRepository extends CrudRepository<VirtualMachine, Long> {

    @Query("select count(*) from virtualmachine where HostID = :hostID")
    int countVmsInHost(@Param("hostID") Long hostID);

    @Query("select vmID from virtualmachine where HostID = :hostID")
    List<Integer> listVmsInHost(@Param("hostID") Long hostID);

    @Query("select vm from virtualmachine vm where vm.hostID = :hostID")
    List<VirtualMachine> vmsInHost(@Param("hostID") Long hostID);

//    @Query("select vmID, vmname, hostID, OS, cpucount, memresource from virtualmachine where HostID = :hostID")
//    List<VirtualMachine> vmsInHost(@Param("hostID") Long hostID);
}
