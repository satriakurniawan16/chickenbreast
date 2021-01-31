package com.satriakurniawan.chickenbreastrecipe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeResult(

    @SerializedName("strMeal")
    @Expose
    var strMeal: String? = null,

    @SerializedName("strMealThumb")
    @Expose
    var strMealThumb: String? = null,

    @SerializedName("idMeal")
    @Expose
    var idMeal : String? = null

)