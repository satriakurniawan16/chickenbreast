package com.satriakurniawan.chickenbreastrecipe.ui.main

import android.annotation.SuppressLint
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
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity(), MainInfoView {

//    private var modelList: MutableList<MainModel> = mutableListOf()

    private var list = ArrayList<MainModel>()

    private lateinit var presenter: MainInfoPresenter

    private lateinit var mainAdapter: MainAdapter
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
            }
        })
    }

    override fun showMainInfo(data: List<RecipeResult>) {
        Log.d("disini", "showMainInfo: ")
        Log.d("tes isinya", "showMainInfo: " + data[0].idMeal)
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
        presenter.getInfoLeague()
    }

}
