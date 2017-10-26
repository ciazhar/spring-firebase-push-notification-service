package com.ciazhar.firebasepushnotification.service

import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.support.HttpRequestWrapper

/**
 * Created by ciazhar on 10/27/17.
 *
 * [ Documentation Here ]
 */

class HeaderRequestInterceptor (private var headerName : String,
                                private var headerValue : String)
    : ClientHttpRequestInterceptor{

    override fun intercept(request: HttpRequest?, body: ByteArray?, execution: ClientHttpRequestExecution?)
            : ClientHttpResponse? {
        var wrapper = HttpRequestWrapper(request)
        wrapper.headers.set(headerName,headerValue)
        return execution?.execute(wrapper,body)
    }

}