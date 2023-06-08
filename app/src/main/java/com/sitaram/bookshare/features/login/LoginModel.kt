package com.sitaram.bookshare.features.login

class LoginModel : LoginContract.Model {

    // implement the userLogin method
    override fun userLogin(username: String, password: String): Boolean {

        val isLoginSuccess: Boolean? = userDao.loginDetails(userName, userPassword)
        return if (isSuccess==true) {
            true
        } else {
            false
        }
    }

    // implement the userRegister method
    override fun userRegister(email: String, username: String, password: String): Boolean {
        val isRregisterSuccess: Boolean? = userDao.registerDetails(userName, userPassword)
        return if (isRregisterSuccess==true) {
            true
        } else {
            false
        }
    }
}