package com.example.singinsingupimitation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.singinsingupimitation.databinding.ActivitySingInSingUpBinding

class SingInSingUp : AppCompatActivity() {
    lateinit var viewBinding: ActivitySingInSingUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivitySingInSingUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        if (intent.getStringExtra("key1") == "testUp") {
            viewBinding.btLogin.visibility = View.GONE
            viewBinding.btRegistration.visibility = View.VISIBLE
            viewBinding.etName.visibility = View.VISIBLE
            viewBinding.etSurname.visibility = View.VISIBLE
        } else if (intent.getStringExtra("key1") == "testIn") {
            viewBinding.btLogin.visibility = View.VISIBLE
            viewBinding.btRegistration.visibility = View.GONE
        }
    }


    lateinit var login: String
    lateinit var name: String
    lateinit var surname: String

    lateinit var password: String
    var login_registret: String = "t"
    var password_registret: String = "t"

    fun onClickRegistration(view: View) {
        login = viewBinding.etLogin.text.toString()
        password = viewBinding.etPassword.text.toString()
        name = viewBinding.etName.text.toString()
        surname = viewBinding.etSurname.text.toString()
        if ( name!=""&&login!=""&&surname!=""&&password!=""){
            intent.putExtra("name", "$name").toString()
            intent.putExtra("surname", "$surname").toString()
            intent.putExtra("login", "$login").toString()
            setResult(RESULT_OK, intent)
            finish()
        }
        else {
            setResult(RESULT_CANCELED)
           viewBinding.tvInfo.text="enter all data"
        }
    }

    fun onCLickLogin(view: View) {


        login = viewBinding.etLogin.text.toString()
        password = viewBinding.etPassword.text.toString()
        if (login == login_registret && password == password_registret) {
            intent.putExtra("t", "sukaaa").toString()
            intent.putExtra("name", "Alex").toString()
            intent.putExtra("surname", "Jonson").toString()
            intent.putExtra("login", "t").toString()
            setResult(RESULT_OK, intent)
            finish()
        } else {
            viewBinding.tvInfo.text = getString(R.string.wrong_Password)
            setResult(RESULT_CANCELED)
        }

    }
}