package com.example.fundamentals.presenters

import com.example.fundamentals.API.Games
import com.example.fundamentals.contracts.MainContract
import com.example.fundamentals.model.MainModel

class MainPresenter(_view: MainContract.MainView): MainContract.MainPresenter {

    private var view: MainContract.MainView = _view
    private var model: MainContract.MainModel = MainModel()

    init {
        view.initView()
    }

    override fun getDataFromServer(name: String) {
        model.getDataFromServer(name)
        view.updateViewData()
    }

    override fun getDataHere(): ArrayList<Games> {
        return model.getDataHere()
    }
}