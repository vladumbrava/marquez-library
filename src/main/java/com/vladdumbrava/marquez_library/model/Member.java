package com.vladdumbrava.marquez_library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "members")
@Data
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
