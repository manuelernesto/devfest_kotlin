package io.github.manuelernesto.devfestapp.util

import io.github.manuelernesto.devfestapp.data.Speaker
import java.util.ArrayList

class Dummy {
    companion object {
        fun getAgendaCloud(): List<Speaker> {
            val name =
                arrayListOf("Manuel Ernesto", "Pawan Kumar")
            val talk = arrayListOf(
                "Build Rest API with Kotlin",
                "Getting Started With Flutter for Web"
            )
            val job = arrayListOf(
                "Kotlin and Firebase Developer",
                "Google Developer Expert, Flutter and Firebase"
            )

            val photo = arrayListOf(
                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
                "https://avatars1.githubusercontent.com/u/12619420?s=400&u=eac38b075e4e4463edfb0f0a8972825cf7803d4c&v=4"
            )
            val time = arrayListOf("10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM")
            val mSpeakers = ArrayList<Speaker>()

            for (i in 0 until name.size) {
                mSpeakers.add(
                    Speaker(
                        name[i],
                        talk[i],
                        job[i],
                        time[i],
                        photo[i]
                    )
                )
            }

            return mSpeakers
        }

        fun getSpeakrs(): List<Speaker> {
            val name =
                arrayListOf("Manuel Ernesto", "Pawan Kumar", "Pedro Massango", "Braulio Cassule")
            val talk = arrayListOf(
                "Build Rest API with Kotlin",
                "Getting Started With Flutter for Web",
                "Deep dive into Flutter",
                "Introduction to Go Programming Language (GoLang)"
            )
            val job = arrayListOf(
                "Kotlin and Firebase Developer",
                "Google Developer Expert, Flutter and Firebase",
                "Flutter Developer",
                "Software Engineer"
            )

            val photo = arrayListOf(
                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
                "https://avatars1.githubusercontent.com/u/12619420?s=400&u=eac38b075e4e4463edfb0f0a8972825cf7803d4c&v=4",
                "https://avatars2.githubusercontent.com/u/33294549?s=400&v=4r",
                "https://avatars1.githubusercontent.com/u/20057010?s=400&v=4"
            )
            val time = arrayListOf("10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM")
            val mSpeakers = ArrayList<Speaker>()

            for (i in 0 until name.size) {
                mSpeakers.add(
                    Speaker(
                        name[i],
                        talk[i],
                        job[i],
                        time[i],
                        photo[i]
                    )
                )
            }

            return mSpeakers
        }

        fun getTeam(): List<Speaker> {
            val name =
                arrayListOf("Manuel Ernesto", "Pedro Massango", "Braulio Cassule")
            val gdg = arrayListOf(
                "GDG Lubango",
                "GDG Luanda",
                "GDG Luanda"
            )
            val job = arrayListOf(
                "Kotlin and Firebase Developer",
                "Flutter Developer",
                "Software Engineer"
            )

            val photo = arrayListOf(
                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
                "https://avatars2.githubusercontent.com/u/33294549?s=400&v=4r",
                "https://avatars1.githubusercontent.com/u/20057010?s=400&v=4"
            )

            val mSpeakers = ArrayList<Speaker>()

            for (i in 0 until name.size) {
                mSpeakers.add(
                    Speaker(
                        name[i],
                        gdg[i],
                        job[i],
                        "",
                        photo[i]
                    )
                )
            }

            return mSpeakers
        }
    }
}