package com.satriakurniawan.chickenbreastrecipe.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailRecipeResult (

    @SerializedName("strMeal")
    @Expose
    var strMeal: String? = null,

    @SerializedName("strInstructions")
    @Expose
    var strInstructions: String? = null,

    @SerializedName("strMealThumb")
    @Expose
    var strMealThumb: String? = null

    )
