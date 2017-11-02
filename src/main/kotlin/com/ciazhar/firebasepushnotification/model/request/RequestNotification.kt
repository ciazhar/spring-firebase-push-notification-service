package com.ciazhar.firebasepushnotification.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * Created by ciazhar on 11/2/17.
 *
 * [ Documentation Here ]
 */

data class RequestNotification(
    @field: NotEmpty
    var to : String?=null,

    @field: NotEmpty
    var animeTitle : String?=null,

    @field: NotEmpty
    var username : String?=null,

    @field: NotEmpty
    var review : String?=null,

    @field: NotEmpty
    var slug: String?=null
)