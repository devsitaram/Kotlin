package com.sitaram.bookshare.features.login

import android.content.Context

class LoginPresenter : LoginContract.Presenter {

    private val view: LoginContract.View? = null
    private val loginModel: LoginModel? = null

    var context: Context? = null

    constructor(view: LoginContract.View, context: Context) {
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
        val isLoginSuccess: Boolean? = loginModel?.userLogin(username, password)
        if (isLoginSuccess == true) {
//            navigateToHome()
            view?.navigateToHome()
        } else {
            view?.loginErrorMessage("Please enter the valid details!")
        }
    }

    override fun registerButtonClick(email: String, username: String, password: String) {
        TODO("Not yet implemented")
    }
}