package com.zamzam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zamzam.helloworld.databinding.ActivityDetailBinding
import com.zamzam.helloworld.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}