package com.sitaram.bookshare.features.login

import android.R

interface LoginContract {
    // create the interface view class
    interface View {
        fun loginSuccessMessage(success: String)
        fun loginErrorMessage(error: String)
    }

    // interface Presenter
    interface Presenter {

    }

    // interface Model
    interface Model {

    }
}