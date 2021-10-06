package com.example.updown

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.updown.databinding.UpdownFragmentBinding
import android.app.PendingIntent
import android.graphics.*
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: UpdownFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdownFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}
