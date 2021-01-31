package com.satriakurniawan.chickenbreastrecipe.ui.main

import com.satriakurniawan.chickenbreastrecipe.model.RecipeResult

interface MainInfoView {
    fun showMainInfo(data: List<RecipeResult>)
}