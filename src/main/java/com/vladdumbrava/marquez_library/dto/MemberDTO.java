package com.vladdumbrava.marquez_library.dto;

import java.time.LocalDate;

public record MemberDTO (
   long id,
   String name,
   String email,
   String phoneNumber,
   LocalDate registrationDate,
   String subscriptionType
) {}
