package com.example.dagger.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.repositories.ApiRepository
import com.example.rest.Objects.UserWrapper
import com.revotrends.eliteswap.data.local.EmailPassword
import retrofit2.Response
import javax.inject.Inject

class ApiViewModel @Inject constructor(var apiRepository: ApiRepository): ViewModel() {

    fun login (emailPassword: EmailPassword): LiveData<Response<UserWrapper>?>{
        return apiRepository.login(emailPassword)
    }
}