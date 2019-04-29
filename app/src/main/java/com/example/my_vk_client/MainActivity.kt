package com.example.my_vk_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_vk_client.navigation.Navigator
import ru.terrakok.cicerone.Screen

import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = Navigator(this, supportFragmentManager, R.id.content)
//        App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
    }

    override fun onResume() {
        super.onResume()
        App.INCTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.INCTANCE.navigatorHolder.removeNavigator()
    }
}