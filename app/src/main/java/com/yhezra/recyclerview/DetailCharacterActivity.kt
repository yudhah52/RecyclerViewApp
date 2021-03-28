package com.yhezra.recyclerview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yhezra.recyclerview.databinding.ActivityDetailCharacterBinding
import com.yhezra.recyclerview.databinding.ActivityMainBinding

class DetailCharacterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailCharacterBinding

    companion object{
        const val EXTRA_CHARACTER = "ekstra_character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character = intent.getParcelableExtra<SuperHeroes>(EXTRA_CHARACTER) as SuperHeroes
        binding.tvCharName.text = character.name
        binding.tvCharDetail.text = character.detail
        Glide.with(this)
            .load(character.image)
            .into(binding.tvImgCharacter)
//        binding.tvImgCharacter.setImageURI(Uri.parse("character.image"))

    }
}