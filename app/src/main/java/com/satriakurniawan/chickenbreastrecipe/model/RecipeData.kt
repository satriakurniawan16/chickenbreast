package com.satriakurniawan.chickenbreastrecipe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeData(

    @SerializedName("meals")
    @Expose
    val meals: List<RecipeResult>?

)