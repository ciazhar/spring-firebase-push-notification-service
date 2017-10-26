package com.ciazhar.firebasepushnotification.service

import org.springframework.http.HttpEntity
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.concurrent.CompletableFuture

/**
 * Created by ciazhar on 10/27/17.
 *
 * [ Documentation Here ]
 */

@Service
class AndroidPushNotificationsService{
    val FIREBASE_SERVER_KEY = "AIzaSyAYnJ0WyocAPMDlmI6x7cCDsZW1-iNh-yw"
    val FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send"

    @Async
    fun send(entity : HttpEntity<String>) : CompletableFuture<String>{
        var restTemplate = RestTemplate()

        var interceptor = ArrayList<ClientHttpRequestInterceptor>()
        interceptor.add(HeaderRequestInterceptor("Authorization","key="+FIREBASE_SERVER_KEY))
        interceptor.add(HeaderRequestInterceptor("Content-Type","application/json"))
        restTemplate.interceptors = interceptor

        var firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity,String::class.java)

        return CompletableFuture.completedFuture(firebaseResponse)
    }
}