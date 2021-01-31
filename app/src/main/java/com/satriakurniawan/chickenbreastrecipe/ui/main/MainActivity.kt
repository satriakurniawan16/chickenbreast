package com.satriakurniawan.chickenbreastrecipe.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.satriakurniawan.chickenbreastrecipe.R
import com.satriakurniawan.chickenbreastrecipe.model.RecipeResult
import com.satriakurniawan.chickenbreastrecipe.network.ApiRepository
import com.satriakurniawan.chickenbreastrecipe.ui.detail.DetailRecipeActivity
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity(), MainInfoView {

    private var list = ArrayList<MainModel>()

    private lateinit var presenter: MainInfoPresenter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun showRecyclerView() {


        recyclerView = findViewById(R.id.rv_league)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val mainAdapter = MainAdapter(list)
        recyclerView.adapter = mainAdapter

        mainAdapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MainModel) {
                intenttoDetail(data.id)
            }
        })
    }

    private fun intenttoDetail(id : String) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }

    override fun showMainInfo(data: List<RecipeResult>) {
        for (i in data.indices) {
            val meal = MainModel(
                data[i].idMeal!!, data[i].strMealThumb!!, data[i].strMeal!!
            )
            list.add(meal)
        }
        showRecyclerView()
    }

    private fun setData() {
        presenter = MainInfoPresenter(this, ApiRepository(), Gson())
        presenter.getInfoMeal()
    }

}
