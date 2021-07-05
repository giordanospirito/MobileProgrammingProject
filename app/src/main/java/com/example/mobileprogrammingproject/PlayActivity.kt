package com.example.mobileprogrammingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileprogrammingproject.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}