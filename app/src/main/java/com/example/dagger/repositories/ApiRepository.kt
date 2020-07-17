package com.example.dagger.repositories

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger.remote.AppApi
import com.example.rest.Objects.UserWrapper
import com.revotrends.eliteswap.data.local.EmailPassword
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ApiRepository (val appApi: AppApi) {

    @SuppressLint("CheckResult")
    fun login (emailPassword: EmailPassword): LiveData<Response<UserWrapper>?> {
        val data = MutableLiveData<Response<UserWrapper>?>()

        appApi.login(emailPassword)
            .subscribeOn(Schedulers.io())
            .subscribe({ success ->
                data.postValue(success)

            }, { error ->
                data.postValue(null)
            })

        return data
    }

}