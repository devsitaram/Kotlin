package com.sitaram.bookshare.features.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.sitaram.bookshare.R

class LoginActivity : AppCompatActivity() {

    // initialize the global TextInputEditText variable for register details
    private var editSignUpEmail: TextInputEditText? = null
    private var editSignUpUsername: TextInputEditText? = null
    private var editSignUpPassword: TextInputEditText? = null

    // initialize the global TextInputEditText variable for login details
    private var editLoginUsername: TextInputEditText? = null
    private var editLoginPassword: TextInputEditText? = null

    private var btnShowLogInPage: Button? = null
    private var btnShowSignUpPage: Button? = null

    private var signUpLayout: View? = null
    private var logInLayout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // initialize the signup input textFiled
        editSignUpEmail = findViewById(R.id.inputSignUpEmail)
        editSignUpUsername = findViewById(R.id.inputSignUpUsername)
        editSignUpPassword = findViewById(R.id.inputSignUpPassword)

        // initialize the login input textFiled
        editLoginUsername = findViewById(R.id.inputLoginUsername)
        editLoginPassword = findViewById(R.id.inputLoginPasswords)

//        // button initialization
//        val btnLogin = findViewById<Button>(R.id.btnLogIn) // login botton
//        val btnSignUp = findViewById<Button>(R.id.btnSignUp) // sign up botton
//        val btnCheckBok = findViewById<Button>(R.id.btnCheckBok)

        // button initialize
        btnShowLogInPage = findViewById(R.id.btnLoginLayout)
        btnShowSignUpPage = findViewById(R.id.btnSignupLayout)

        // view initialize
        signUpLayout = findViewById(R.id.signUpLayout) // logInLayout
        logInLayout = findViewById(R.id.logInLayout)

        btnShowSignUpPage?.setOnClickListener {
            signUpFieldsVisible()
        }
        btnShowLogInPage?.setOnClickListener {
            loginFieldsVisible()
        }
    }

    // login layout visibility
    @SuppressLint("UseCompatLoadingForDrawables")
    fun loginFieldsVisible(){
        btnShowSignUpPage?.setTextColor(resources.getColor(R.color.textOrange, null))
        btnShowLogInPage?.background = resources.getDrawable(R.drawable.switch_tricks, null)
        btnShowSignUpPage?.background = null
        signUpLayout?.visibility = View.GONE
        logInLayout?.visibility = View.VISIBLE
        btnShowLogInPage?.setTextColor(resources.getColor(R.color.textColor, null))
    }


    // signup layout visibility
    @SuppressLint("UseCompatLoadingForDrawables")
    fun signUpFieldsVisible() {
        btnShowSignUpPage!!.background = resources.getDrawable(R.drawable.switch_tricks, null)
        btnShowSignUpPage!!.setTextColor(resources.getColor(R.color.textColor, null))
        btnShowLogInPage!!.background = null
        logInLayout!!.visibility = View.GONE
        signUpLayout!!.visibility = View.VISIBLE
        btnShowLogInPage!!.setTextColor(resources.getColor(R.color.textOrange, null))
    }
}