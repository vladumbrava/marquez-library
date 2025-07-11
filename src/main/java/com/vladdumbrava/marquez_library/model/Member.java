package com.vladdumbrava.marquez_library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "members")
@Data
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    private long memberId;

    @Column(name = "name")
    private String memberName;

    @Column(name = "email")
    private String memberEmail;

    @Column(name = "phone_number")
    private String memberPhoneNumber;

    @Column(name = "registration_date")
    private String memberRegistrationDate;

    @Column(name = "subscription_type")
    private String memberSubscriptionType;

}
