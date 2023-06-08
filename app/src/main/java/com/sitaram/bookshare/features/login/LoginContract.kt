package com.sitaram.bookshare.features.login

interface LoginContract {
    // create the interface view class
    interface View {
        fun loginSuccessMessage(success: String)
        fun loginErrorMessage(error: String)
        fun navigateToHome()
        fun loginButtonClick(username: String, password: String)
    }

    // interface Presenter
    interface Presenter {
        fun loginButtonClick(username: String, password: String)
        fun registerButtonClick(email: String, username: String, password: String)
    }

    // interface Model
    interface Model {
        fun userLogin(username: String, password: String): Boolean
        fun register(email: String, username: String, password: String): Boolean
    }
}