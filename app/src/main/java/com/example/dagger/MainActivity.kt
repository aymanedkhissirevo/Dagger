package com.example.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.dagger.viewModels.ApiViewModel
import com.revotrends.eliteswap.data.local.EmailPassword
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var apiViewModel: ApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailPassword = EmailPassword("aymandkhissi@gmail.com","azertyuiop")
        apiViewModel = ViewModelProviders.of(this,factory).get(ApiViewModel::class.java)

        txt.setOnClickListener {
            apiViewModel.login(emailPassword).observe(this, Observer {
                if (it!!.isSuccessful){
                    txt.text=it.message()
                }
            })
        }






    }


}