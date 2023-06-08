package com.sitaram.bookshare.features.login

class LoginModel : LoginContract.Model {

    // implement the userLogin method
    override fun userLogin(username: String, password: String): Boolean {
        return true
    }

    // implement the userRegister method
    override fun userRegister(email: String, username: String, password: String): Boolean {
        return true
    }
}