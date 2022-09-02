package com.example.videoplayer_kotlin

import android.R
import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.videoplayer_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Find the VideoView class by its id
        val videoView = findViewById<VideoView>(binding.testView.id)
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //specify the location of media file
        val uri:Uri = parse(
            "android.resource://" + packageName
                    + "/raw/test"
        )
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }

}
