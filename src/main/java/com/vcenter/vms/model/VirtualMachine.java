package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Generated;
import javax.persistence.*;

@Data
@Entity (name = "virtualmachine")
@Table (name = "VirtualMachine")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class VirtualMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vmID;

    @Column(name = "vmname")
    private String vmName;
    private int hostID;
    @Column(name = "os")
    private String OS;
    @Column(name = "cpucores")
    private int cpuCores;
    @Column(name = "memresource")
    private int memResource;
}
