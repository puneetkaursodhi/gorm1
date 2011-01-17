package com.intelligrape

class Car {
    String name
    String model
    Engine engine
    static constraints = {
        name(nullable:false)
    }
}