package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
@Data
public class Summary {
    private Integer noOfClusters;
    private Integer noOfHosts;
    private Integer noOfVms;



    public Summary (Long noOfHosts, Long noOfVms){
        Integer noOfHostInt = noOfHosts == null ? null : Math.toIntExact(noOfHosts);
        Integer noOfVmsInt = noOfVms == null ? null : Math.toIntExact(noOfVms);
        this.noOfClusters = null;
        this.noOfHosts = noOfHostInt;
        this.noOfVms = noOfVmsInt;
    }

    public Summary (Long noOfClusters, Long noOfHosts, Long noOfVms){
        Integer noOfClustersInt = noOfClusters == null ? null : Math.toIntExact(noOfClusters);
        Integer noOfHostsInt = noOfHosts == null ? null : Math.toIntExact(noOfHosts);
        Integer noOfVmsInt = noOfVms == null ? null : Math.toIntExact(noOfVms);
        this.noOfClusters = noOfClustersInt;
        this.noOfHosts = noOfHostsInt;
        this.noOfVms = noOfVmsInt;
    }

}
