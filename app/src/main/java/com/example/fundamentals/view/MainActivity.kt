package com.example.fundamentals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fundamentals.view.adapters.GamesAdapter
import com.example.fundamentals.R
import com.example.fundamentals.contracts.MainContract
import com.example.fundamentals.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private var presenter: MainPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
    }

    override fun initView() {
        gamesList.layoutManager = LinearLayoutManager(this)
        searchButton.setOnClickListener { presenter?.getDataFromServer(gameName.text.toString())}
    }

    override fun updateViewData() {
        var gamesAdapter =
            GamesAdapter(presenter?.getDataHere())
        gamesList.adapter = gamesAdapter
    }
}
