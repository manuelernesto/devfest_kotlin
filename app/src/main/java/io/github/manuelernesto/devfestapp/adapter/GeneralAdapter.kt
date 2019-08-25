package io.github.manuelernesto.devfestapp.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import io.github.manuelernesto.devfestapp.R
import io.github.manuelernesto.devfestapp.data.Speaker
import kotlin.random.Random

class GeneralAdapter(private val mSpeakers: List<Speaker>, val context: Context) :
    RecyclerView.Adapter<GeneralAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.general_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mSpeakers.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = mSpeakers[position]
        holder.bind(speaker)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.txt_name)
        var talk: TextView = itemView.findViewById(R.id.txt_talk)
        var job: TextView = itemView.findViewById(R.id.txt_job)
        var photo: ImageView = itemView.findViewById(R.id.photo)
        var view: View = itemView.findViewById(R.id.view)


        fun bind(speaker: Speaker) {
            name.text = speaker.name
            talk.text = speaker.talk
            job.text = speaker.job
            Glide.with(context).load(speaker.photo).into(photo)
            setRandomColor()
        }

        private fun setRandomColor() {
            val colors = arrayListOf(
                R.color.colorAmber,
                R.color.colorRed,
                R.color.colorBlue,
                R.color.colorGreen
            )
            val p = Random.nextInt(colors.size)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.setBackgroundColor(context.resources.getColor(colors[p], null))
            }
        }
    }
}