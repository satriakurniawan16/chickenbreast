package com.satriakurniawan.chickenbreastrecipe.network

object ApiRequest {


    fun getInfoMeal(): String {
        return "https://www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast"
    }

    fun getInfoMealbyId(id: String): String {
        return "https://www.themealdb.com/api/json/v1/1/lookup.php?i=$id"
    }


}