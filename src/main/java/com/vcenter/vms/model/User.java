package com.vcenter.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class User {

    @Id
    @GeneratedValue
    private Long userID;

    private String username;
    @Column(name = "roletype")
    private String roleType;
    private String password;
}
