package com.ciazhar.firebasepushnotification

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FirebasePushNotificationApplication{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(FirebasePushNotificationApplication::class.java, *args)
        }
    }
}