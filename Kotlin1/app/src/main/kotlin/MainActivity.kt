package com.example.rodolfo.kotlin1

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import com.example.rodolfo.kotlin1.FlowersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mToolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(mToolbar)
        mToolbar.setTitle("Teste Kotlin")

        if(savedInstanceState == null){
            changeFragment(FlowersFragment())
        }

    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false){
        val ft =  supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit);
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null);
        ft.commit()
    }
}
