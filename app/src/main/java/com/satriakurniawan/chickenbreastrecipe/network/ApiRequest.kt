package com.satriakurniawan.chickenbreastrecipe.network

object ApiRequest {


    fun getInfoMeal(): String {
        return "https://www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast"
    }

    fun getInfoTeam(id: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$id"
    }


}