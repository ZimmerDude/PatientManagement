package com.mysterio.cowin

class User
{
    var id : Int = 0
    var name : String = ""
    var age : Int = 0
    var email : String = ""
    var phone : String = ""
    var gender:String =""
    var covid : String = ""
    var hospital : String = ""
    var discharge : String = ""


    constructor(name:String,age:Int,email:String,phone:String,gender:String,covid:String,hospital:String,discharge:String)
    {
        this.name=name
        this.age=age
        this.email=email
        this.phone=phone
        this.gender=gender
        this.covid=covid
        this.hospital=hospital
        this.discharge = discharge


    }
    constructor()
}