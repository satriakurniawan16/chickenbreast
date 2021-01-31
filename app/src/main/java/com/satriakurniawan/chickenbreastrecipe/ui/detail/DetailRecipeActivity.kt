package com.satriakurniawan.chickenbreastrecipe.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.satriakurniawan.chickenbreastrecipe.R
import com.satriakurniawan.chickenbreastrecipe.model.DetailRecipeResult
import com.satriakurniawan.chickenbreastrecipe.network.ApiRepository
import com.satriakurniawan.chickenbreastrecipe.ui.main.MainInfoPresenter
import com.satriakurniawan.chickenbreastrecipe.ui.main.MainInfoView
import kotlinx.android.synthetic.main.activity_detail_recipe.*
import kotlinx.android.synthetic.main.item_meal.view.*

class DetailRecipeActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)
        setData()
    }

    override fun showDetailInfo(data: List<DetailRecipeResult>) {
        title_recipe.setText(data[0].strMeal)
        Glide.with(this)
            .load(data[0].strMealThumb)
            .into(image_recipe)
        desc_recipe.setText(data[0].strInstructions)
    }

    private fun setData() {
        presenter = DetailPresenter(this, ApiRepository(), Gson())
        intent.getStringExtra("id")?.let { presenter.getDetailInfoMeal(it) }
    }
}