package com.sitaram.bookshare.features.login

import android.content.Context
import android.util.Log

class LoginPresenter : LoginContract.Presenter {

    // initialize the variable
    private var view: LoginContract.View? = null
    private var loginModel: LoginModel = LoginModel()
    var context: Context? = null

    constructor(view: LoginContract.View, context: Context) {
        this.view = view
        this.context = context
    }

    override fun loginButtonClick(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            view?.loginErrorMessage("The fields is empty!")
        } else {
            loginDetail(username, password)
        }
    }

    // login details methods call to model class's userLogin methods
    private fun loginDetail(username: String, password: String) {

        var isLoginSuccess: Boolean? = loginModel.userLogin(username, password)
        // check the login is success or not
        if (isLoginSuccess == true) {
            view?.navigateToHome()
        } else {
            view?.loginErrorMessage("Please enter the valid details!")
        }
    }

    // register user details
    override fun registerButtonClick(email: String, username: String, password: String) {
        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            view?.loginErrorMessage("The fields is empty!")
        } else {
            val isEmail = view?.emailValidation(email)
            val isUsername = view?.emailValidation(username)
            val isPassword = view?.emailValidation(password)
            if (isEmail == true || isUsername == true || isPassword == true) {
                registerDetails(email, username, password)
            }
        }
    }

    private fun registerDetails(email: String, username: String, password: String) {
        var isRegisterSuccess: Boolean? = loginModel.userRegister(email, username, password)
        if (isRegisterSuccess == true) {
            view?.navigateToLoginPage()
        } else {
            view?.loginErrorMessage("Please enter the valid details!")
        }
    }
}