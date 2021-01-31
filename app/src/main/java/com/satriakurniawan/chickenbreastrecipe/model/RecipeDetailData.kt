package com.satriakurniawan.chickenbreastrecipe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeDetailData(

    @SerializedName("meals")
    @Expose
    val meals: List<DetailRecipeResult>?

)