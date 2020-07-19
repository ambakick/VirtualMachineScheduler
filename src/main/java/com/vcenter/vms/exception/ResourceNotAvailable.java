package com.vcenter.vms.exception;

public class ResourceNotAvailable extends RuntimeException {

    public ResourceNotAvailable(String errorMessage) {
        super(errorMessage);
    }
}
