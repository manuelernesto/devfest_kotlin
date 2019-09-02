package io.github.manuelernesto.devfestapp.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import io.github.manuelernesto.devfestapp.R
import io.github.manuelernesto.devfestapp.util.DevfesPreferences
import kotlinx.android.synthetic.main.activity_main.*


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

        checkDarMode()

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
                chooseThemeDialog()
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

    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val animals = arrayOf(
            getString(R.string.light_txt),
            getString(R.string.dark),
            getString(R.string.system_default)
        )

        val checkedItem = DevfesPreferences(this).darkMode
        builder.setSingleChoiceItems(animals, checkedItem) { dialog, which ->

            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    DevfesPreferences(this).darkMode = 0
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    DevfesPreferences(this).darkMode = 1
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    DevfesPreferences(this).darkMode = 2
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()


    }

    private fun checkDarMode() {
        when (DevfesPreferences(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                DevfesPreferences(this).darkMode = 0
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
                DevfesPreferences(this).darkMode = 1
            }

            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
                DevfesPreferences(this).darkMode = 2
            }

        }
    }
}