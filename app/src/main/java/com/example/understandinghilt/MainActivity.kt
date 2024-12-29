package com.example.understandinghilt

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.understandinghilt.ui.theme.UnderstandingHiltTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    @Named("changeEmail")
    lateinit var userRepository: UserRepository

    @Inject
    @Named("changeEmail")
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnderstandingHiltTheme {
                userRepository.showData()
                userRepository.saveUser("changesEmail","1111")
                Log.d("TAG","emailNowChanged")
                userRepository2.showData()
            }
        }
    }
}

