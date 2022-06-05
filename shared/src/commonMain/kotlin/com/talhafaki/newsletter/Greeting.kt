package com.talhafaki.newsletter

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}