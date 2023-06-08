package com.sitaram.bookshare.features.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.sitaram.bookshare.MainActivity
import com.sitaram.bookshare.R

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private var loginPresenter: LoginPresenter? = null

    // initialize the global TextInputEditText variable for register details
    private var editSignUpEmail: TextInputEditText? = null
    private var editSignUpUsername: TextInputEditText? = null
    private var editSignUpPassword: TextInputEditText? = null

    // initialize the global TextInputEditText variable for login details
    private var editLoginUsername: TextInputEditText? = null
    private var editLoginPassword: TextInputEditText? = null

    private var btnShowLogInPage: Button? = null
    private var btnShowRegisterPage: Button? = null

    private var signUpLayout: View? = null
    private var logInLayout: View? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this, this)
        // initialize the signup input textFiled
        editSignUpEmail = findViewById(R.id.inputSignUpEmail)
        editSignUpUsername = findViewById(R.id.inputSignUpUsername)
        editSignUpPassword = findViewById(R.id.inputSignUpPassword)

        // initialize the login input textFiled
        editLoginUsername = findViewById(R.id.inputLoginUsername)
        editLoginPassword = findViewById(R.id.inputLoginPasswords)

//        // button initialization
        val btnLogin = findViewById<Button>(R.id.btnLogIn) // login botton
        val btnSignUp = findViewById<Button>(R.id.btnSignUp) // sign up botton
//        val btnCheckBok = findViewById<Button>(R.id.btnCheckBok)

        // button initialize
        btnShowLogInPage = findViewById(R.id.btnLoginLayout)
        btnShowRegisterPage = findViewById(R.id.btnRegisterLayout)

        // view initialize
        signUpLayout = findViewById(R.id.signUpLayout) // logInLayout
        logInLayout = findViewById(R.id.logInLayout)

        btnShowRegisterPage?.setOnClickListener { signUpFieldsVisible() }
        btnShowLogInPage?.setOnClickListener { loginFieldsVisible() }

        // login button setOnClickListener
        btnLogin.setOnClickListener {
            val username = editLoginUsername?.text.toString().trim()
            val password = editLoginPassword?.text.toString().trim()
            loginButtonClick(username, password) // call the loginButtonClick methods
        }

        btnSignUp.setOnClickListener {
            val email = editSignUpEmail?.text.toString().trim()
            val username = editSignUpUsername?.text.toString().trim()
            val password = editSignUpPassword?.text.toString().trim()
            // call the loginButtonClick methods
            registerButtonClick(email, username, password)
        }
    }

    // loginButtonClick which is call the loginPresenter class's method
    private fun loginButtonClick(username: String, password: String) {
        loginPresenter?.loginButtonClick(username, password)
    }

    private fun registerButtonClick(email: String, username: String, password: String){
        loginPresenter?.registerButtonClick(email,username, password)
    }
    // login layout visibility
    @SuppressLint("UseCompatLoadingForDrawables")
    fun loginFieldsVisible() {
        btnShowRegisterPage?.setTextColor(resources.getColor(R.color.textOrange, null))
        btnShowLogInPage?.background = resources.getDrawable(R.drawable.switch_tricks, null)
        btnShowRegisterPage?.background = null
        signUpLayout?.visibility = View.GONE
        logInLayout?.visibility = View.VISIBLE
        btnShowLogInPage?.setTextColor(resources.getColor(R.color.textColor, null))
    }

    // signup layout visibility
    @SuppressLint("UseCompatLoadingForDrawables")
    fun signUpFieldsVisible() {
        btnShowRegisterPage?.background = resources.getDrawable(R.drawable.switch_tricks, null)
        btnShowRegisterPage?.setTextColor(resources.getColor(R.color.textColor, null))
        btnShowLogInPage?.background = null
        logInLayout?.visibility = View.GONE
        signUpLayout?.visibility = View.VISIBLE
        btnShowLogInPage?.setTextColor(resources.getColor(R.color.textOrange, null))
    }

    // show the valid/success toast message
    override fun loginSuccessMessage(success: String) {
        // toast message
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show()
    }

    // show the error toast message
    override fun loginErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLoginPage() {
        loginFieldsVisible()
    }

    // navigate from login activity to main activity
    override fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun emailValidation(email: String): Boolean {

        // get text fields text
        val emailPattern = Regex("[a-zA-Z\\d._-]+@[a-z]+.+[a-z]+")
        // check the email pattern
        return if (!email.matches(emailPattern)) {
            editSignUpEmail?.error = "Invalid email address"
            false
        } else {
            editSignUpEmail?.error = null
            true
        }
    }

    override fun usernameValidation(name: String): Boolean {
        // get text fields text
        val usernamePattern = Regex("[a-zA-z]+\\s+[a-zA-z]+")
        // check the username pattern
        return if (!name.matches(usernamePattern)) {
            editSignUpEmail?.error = "Invalid username!"
            false
        } else {
            editSignUpEmail?.error = null
            true
        }
    }

    override fun passwordValidation(password: String): Boolean {
        // get text fields text
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        // check the password pattern
        return if (!password.matches(passwordPattern)) {
            editSignUpEmail?.error = "Invalid Password!"
            false
        } else {
            editSignUpEmail?.error = null
            true
        }
    }


}