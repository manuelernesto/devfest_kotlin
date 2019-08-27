package io.github.manuelernesto.devfestapp.ui

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import io.github.manuelernesto.devfestapp.R
import io.github.manuelernesto.devfestapp.util.DevfesPreferences
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = getString(R.string.title_home)
        setSupportActionBar(toolbar)

        mNavController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupWithNavController(toolbar, mNavController)
        NavigationUI.setupActionBarWithNavController(this, mNavController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> {
                share()
            }
            R.id.menu_darkOn -> {
                darkMode()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun share() {
        try {
            val link = getString(R.string.txt_github)
            val productDesc =
                "Check the repository of Devfest App make with kotlin and share with your tech friends.\n$link"
            val intent = Intent(Intent.ACTION_SEND)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(Intent.EXTRA_TEXT, productDesc)
            intent.type = "image/png"
            startActivity(Intent.createChooser(intent, "Share"))
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun darkMode() {
        when (DevfesPreferences(this).darkMode) {
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                DevfesPreferences(this).darkMode = 2
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
                DevfesPreferences(this).darkMode = 1
            }
        }

    }
}
