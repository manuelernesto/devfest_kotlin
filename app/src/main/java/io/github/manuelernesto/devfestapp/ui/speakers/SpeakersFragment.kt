package io.github.manuelernesto.devfestapp.ui.speakers

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import io.github.manuelernesto.devfestapp.R
import io.github.manuelernesto.devfestapp.adapter.AgendaAdapter
import io.github.manuelernesto.devfestapp.adapter.GeneralAdapter
import io.github.manuelernesto.devfestapp.util.Dummy

class SpeakersFragment : Fragment() {

    companion object {
        fun newInstance() = SpeakersFragment()
    }

    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.speakers_fragment, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.rv_speakers)
            val adapter = GeneralAdapter(Dummy.getSpeakrs(), context)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
    }

}
