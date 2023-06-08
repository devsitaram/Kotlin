package com.sitaram.bookshare.features.login

interface LoginContract {
    // create the interface view class
    interface View {
        fun loginSuccessMessage(success: String)
        fun loginErrorMessage(error: String)
        fun navigateToHome()
        fun navigateToLoginPage()
        fun emailValidation(email: String): Boolean
        fun usernameValidation(name: String): Boolean
        fun passwordValidation(password: String): Boolean
    }

    // interface Presenter
    interface Presenter {
        fun loginButtonClick(username: String, password: String)
        fun registerButtonClick(email: String, username: String, password: String)
    }

    // interface Model
    interface Model {
        fun userLogin(username: String, password: String): Boolean
        fun userRegister(email: String, username: String, password: String): Boolean
    }
}