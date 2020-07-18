package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity (name="virtualmachine")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class VirtualMachine {

    @Id
    @GeneratedValue
    private Long vmID;

    @Column(name = "vmname")
    private String vmName;
    private Long hostID;
    private String OS;
    @Column(name = "cpucount")
    private int cpuCount;
    @Column(name = "memresource")
    private int memResource;
}
