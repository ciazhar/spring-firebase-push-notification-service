package com.ciazhar.firebasepushnotification.controller

import com.ciazhar.firebasepushnotification.model.request.RequestNotification
import com.ciazhar.firebasepushnotification.service.AndroidPushNotificationsService
import org.json.JSONObject
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import javax.validation.Valid

/**
 * Created by ciazhar on 10/27/17.
 *
 * [ Documentation Here ]
 */

@RestController
class AndroidPushNotificationController (private val service: AndroidPushNotificationsService){

    @PostMapping("/send")
    fun send(@Valid @RequestBody request: RequestNotification): ResponseEntity<*> {

        val body = JSONObject()
        body.put("to", request.to)
        body.put("priority", "high")

        val notification = JSONObject()
        notification.put("title", request.animeTitle)
        notification.put("body", request.username+" write review : "+request.review)

        val data = JSONObject()
        data.put("slug", request.slug)

        body.put("notification", notification)
        body.put("data", data)

        val response = HttpEntity(body.toString())
        val pushNotification: CompletableFuture<String> = service.send(response)
        CompletableFuture.allOf(pushNotification)

        val firebaseResponse = pushNotification.get()
        return ResponseEntity(firebaseResponse, HttpStatus.OK)

    }
}