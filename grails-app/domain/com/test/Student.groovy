package com.test

import groovy.transform.ToString

@ToString
class Student {
    String name
    String rollNo
    String address
    String email

    static constraints = {
        name(nullable: false,blank: false,size: 1..10)
        rollNo(nullable: false,blank: false)
        address(nullable: false,blank: false)
        email(nullable: false,blank: false)
    }
}
