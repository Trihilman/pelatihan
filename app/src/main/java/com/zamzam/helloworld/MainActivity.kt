package com.zamzam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataHewan = ArrayList<Hewan>().apply {
            add(Hewan("Ayam", R.drawable.ayam))
            add(Hewan("Bebek", R.drawable.bebek))
            add(Hewan("Domba", R.drawable.domba))
            add(Hewan("Kambing", R.drawable.kambing))
            add(Hewan("Sapi", R.drawable.sapi))
        }
    }
}