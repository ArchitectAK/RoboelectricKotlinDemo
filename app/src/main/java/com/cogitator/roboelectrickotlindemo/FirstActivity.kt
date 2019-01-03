package com.cogitator.roboelectrickotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author Ankit Kumar on 03/01/2019
 */
class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    fun buttonClickTest(view: View) {
        val intent = Intent(applicationContext, SecondActivity::class.java)
        startActivity(intent)
    }
}