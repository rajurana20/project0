package com.revature.bankapp.model

class User(var firstName : String, var lastName : String, var street : String, var city:String, var state:String, var phone:Long, var ssn:Long){
    override def toString(): String = {
        s"${firstName}, ${lastName}, ${street}, ${city}, ${state} , ${phone}, ${ssn}"
    }
}