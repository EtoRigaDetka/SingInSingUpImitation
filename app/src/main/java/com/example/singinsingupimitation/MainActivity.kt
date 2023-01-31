package com.example.singinsingupimitation

import android.util.Log
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.singinsingupimitation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }


    var login = ""
    var password = ""
    var name = ""
    var surname = ""
fun onClickExit(view:View){
    viewBinding.iwAvatar.visibility = View.INVISIBLE
    viewBinding.btExit.visibility = View.INVISIBLE
    viewBinding.tvLogin.visibility = View.INVISIBLE
    viewBinding.tvName.visibility = View.INVISIBLE
    viewBinding.tvSurname.visibility = View.INVISIBLE

    viewBinding.btSingUp.visibility=View.VISIBLE
    viewBinding.btSingIn.visibility=View.VISIBLE
}

    fun onClickSingIn(view: View) {
        val intent = Intent(this, SingInSingUp::class.java)
        intent.putExtra("key1","testIn")
        startActivityForResult(intent, 1)
    }

    fun onClickSingUp(view: View) {
        val intent = Intent(this, SingInSingUp::class.java)
        intent.putExtra("key1","testUp")
        startActivityForResult(intent, 2)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode,data)
        if (resultCode== RESULT_OK) {

            viewBinding.iwAvatar.visibility = View.VISIBLE
            viewBinding.btExit.visibility = View.VISIBLE
            viewBinding.tvLogin.visibility = View.VISIBLE
            viewBinding.tvName.visibility = View.VISIBLE
            viewBinding.tvSurname.visibility = View.VISIBLE
            viewBinding.tvName.text = data?.getStringExtra("name").toString()
            viewBinding.tvSurname.text = data?.getStringExtra("surname").toString()
            viewBinding.tvLogin.text = data?.getStringExtra("login").toString()

            viewBinding.btSingUp.visibility=View.GONE
            viewBinding.btSingIn.visibility=View.GONE
        }

    }


}