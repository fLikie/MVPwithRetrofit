package com.example.fundamentals.contracts

import com.example.fundamentals.API.Games

interface MainContract {

    interface MainView {
        fun initView()
        fun updateViewData()
    }

    interface MainPresenter {
        fun getDataFromServer(name: String)
        fun getDataHere(): ArrayList<Games>
    }

    interface MainModel {
        fun getDataHere(): ArrayList<Games>
        fun getDataFromServer(name: String)
    }
}