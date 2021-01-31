package com.satriakurniawan.chickenbreastrecipe.ui.detail

import com.google.gson.Gson
import com.satriakurniawan.chickenbreastrecipe.model.RecipeDetailData
import com.satriakurniawan.chickenbreastrecipe.network.ApiRepository
import com.satriakurniawan.chickenbreastrecipe.network.ApiRequest
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter (
    private val detailMealView: DetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getDetailInfoMeal(id: String) {
        doAsync {
            val data = gson.fromJson(
                apiRepository.doRequest(ApiRequest.getInfoMealbyId(id)),
                RecipeDetailData::class.java
            )

            uiThread {
                data.meals?.let {
                    detailMealView.showDetailInfo(it)
                }
            }
        }
    }
}