package com.example.understandinghilt

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository{
    fun saveUser(email: String,password: String)
    fun showData()
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email : String , password : String){
        Log.d("TAG","User Saved in DB")
    }

    override fun showData() {

    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("TAG","User Saved in FireBase")
    }
    override fun showData() {

    }
}

@Singleton //creates only single object of the following object
class ChangeDatainRepository : UserRepository {
    var currEmail : String = "currEmail@gmail.com"
    override fun saveUser(email: String, password: String) {
        currEmail  = email
    }
    override fun showData(){
        Log.d("TAG","${currEmail}")
    }
}