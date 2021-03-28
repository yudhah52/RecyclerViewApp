package com.yhezra.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yhezra.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnCharacterClickListener {

    private lateinit var binding : ActivityMainBinding
    private val list = ArrayList<SuperHeroes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCharacter.setHasFixedSize(true)

        list.addAll(getListCharacter())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list,this)
        binding.rvCharacter.adapter = listCharacterAdapter
    }

    fun getListCharacter(): ArrayList<SuperHeroes> {
        val dataImage = resources.getStringArray(R.array.character_image)
        val dataName = resources.getStringArray(R.array.character_name)
        val dataDetail = resources.getStringArray(R.array.detail)

        val listCharacter = ArrayList<SuperHeroes>()
        for(i in dataName.indices){
            val superHeroes = SuperHeroes(
                dataImage[i],
                dataName[i],
                dataDetail[i]
            )
            listCharacter.add(superHeroes)
        }
        return listCharacter
    }

    override fun onCharacterClick(character: SuperHeroes, i: Int) {
        val parcelableMove = Intent(this@MainActivity, DetailCharacterActivity::class.java)
        parcelableMove.putExtra(DetailCharacterActivity.EXTRA_CHARACTER,character)
        startActivity(parcelableMove)
    }
}