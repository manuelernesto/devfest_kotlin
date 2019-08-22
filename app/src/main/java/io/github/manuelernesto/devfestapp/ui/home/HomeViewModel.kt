package io.github.manuelernesto.devfestapp.ui.home

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.lifecycle.ViewModel
import io.github.manuelernesto.devfestapp.R
import retrofit2.http.Url

class HomeViewModel : ViewModel() {


    fun openFacebook(view: View) {
        val url = view.context.getString(R.string.urlFacebook)
        loadUrl(view, url)
    }

    fun openTwitter(view: View) {
        val url = view.context.getString(R.string.urlTwitter)
        loadUrl(view, url)
    }

    fun openLinkedin(view: View) {
        val url = view.context.getString(R.string.urlLinkedin)
        loadUrl(view, url)
    }

    fun openYoutube(view: View) {
        val url = view.context.getString(R.string.urlYoutube)
        loadUrl(view, url)
    }

    fun openMeetup(view: View) {
        val url = view.context.getString(R.string.urlMeetup)
        loadUrl(view, url)
    }

    fun sendEmail(view: View) {
        loadUrl(
            view,
            "mailto:alemdadox@gmail.com?subject=Need an App App&body={Name: Manuel Ernesto},Email: alemdadox@gmail.com}"
        )
    }

    private fun loadUrl(view: View, url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
            view.context.startActivity(it)
        }


    }
}
