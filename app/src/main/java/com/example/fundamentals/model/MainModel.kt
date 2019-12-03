package com.example.fundamentals.model

import com.example.fundamentals.API.API
import com.example.fundamentals.API.Games
import com.example.fundamentals.contracts.MainContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainModel: MainContract.MainModel {

    private var gamesList: ArrayList<Games> = ArrayList()

    override fun getDataHere() = gamesList

    override fun getDataFromServer(name: String) {
        CoroutineScope(Dispatchers.IO).async {
            val getGames = API.create().getGamePrices(name, 500, 1, true, "json").await()
            gamesList = getGames.items
        }
    }
}