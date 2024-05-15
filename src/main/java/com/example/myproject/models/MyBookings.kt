package com.example.myproject.models

class MyBookings {
    var from:String=""
    var destination:String=""
    var departure: String=""
    var returndate:String=""
    var id:String=""
    constructor(from:String,destination:String,departure:String,returndate:String,id:String){
        this.from=from
        this.destination=destination
        this.departure=departure
        this.returndate=returndate
        this.id=id
    }
    constructor()

}