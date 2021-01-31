package com.satriakurniawan.chickenbreastrecipe.ui.detail

import com.satriakurniawan.chickenbreastrecipe.model.DetailRecipeResult

interface DetailView {
    fun showDetailInfo(data: List<DetailRecipeResult>)
}