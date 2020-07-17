package com.example.dagger.remote

import com.example.rest.Objects.UserWrapper
import com.revotrends.eliteswap.data.local.EmailPassword
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppApi {

    @POST("api/oth/login")
    fun login(@Body emailPassword: EmailPassword): Single<Response<UserWrapper>>

}