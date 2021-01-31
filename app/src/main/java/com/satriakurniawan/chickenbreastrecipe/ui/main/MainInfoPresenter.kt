package com.satriakurniawan.chickenbreastrecipe.ui.main

import com.google.gson.Gson
import com.satriakurniawan.chickenbreastrecipe.model.RecipeData
import com.satriakurniawan.chickenbreastrecipe.network.ApiRepository
import com.satriakurniawan.chickenbreastrecipe.network.ApiRequest
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainInfoPresenter(
    private val mainMealView: MainInfoView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getInfoLeague() {
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(ApiRequest.getInfoMeal()),
                RecipeData::class.java
            )

            uiThread {
                data.meals?.let {
                    mainMealView.showMainInfo(it)
                }
            }
        }
    }

}