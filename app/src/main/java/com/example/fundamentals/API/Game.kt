package com.example.fundamentals.API

data class Game (val Pagenum: Int, val Pagesize: Int, val Totalpages: Int, val items: ArrayList<Games>)

data class Games (val id: Int, val name: String, val name_eng: String, val price_rur: String, val url: String, val description: String)