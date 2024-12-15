package com.example.easylaptopapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.easylaptopapp.activities.LaptopActivity
import com.example.easylaptopapp.adapters.CategoriesAdapter
import com.example.easylaptopapp.adapters.MostPopularAdapter
import com.example.easylaptopapp.databinding.FragmentHomeBinding
import com.example.easylaptopapp.pojo.MealsByCategory
import com.example.easylaptopapp.pojo.Meal
import com.example.easylaptopapp.pojo.laptop_listItem
import com.example.easylaptopapp.viewModel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var randomLaptop : laptop_listItem
    private lateinit var homeMvvm : HomeViewModel
    private lateinit var popularItemAdapter : MostPopularAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter

     private var popularItemsLiveData = MutableLiveData<List<MealsByCategory>>()

    companion object{
        const val Laptop_ID = "com.example.easylaptopapp.fragments.id"
        const val Laptop_NAME = "com.example.easylaptopapp.fragments.nameProducts"
        const val Laptop_Image = "com.example.easylaptopapp.fragments.imageSource"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMvvm = ViewModelProvider(this)[HomeViewModel::class.java]
        popularItemAdapter = MostPopularAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        RetrofitInstance.api.getRandomLaptop().enqueue(object :Callback<laptop_listItem>{
//            override fun onResponse(call: Call<laptop_listItem>, response: Response<laptop_listItem>) {

//                    val randomlaptop : laptop_listItem = response.body()!!.id[0]
//                    Log.d("TEST","id laptop ${randomlaptop.id} name ${randomlaptop.nameProducts}")
                    Glide.with(this@HomeFragment)
                        .load("https://laptopmedia.com/wp-content/uploads/2023/09/acer-nitro-v-15-anv15-51-non-fingerprint-with-backlit-black-05.tif-custom-scaled-e1695938821469.jpg")
                        .fitCenter()
                        .into(binding.imgRandomlLaptopp)
                    //Tao thanh truot cho HINH ANH NAY


        onRandomLaptopClick()

        preparePopularItemsRecycleView()
        //observePopularIteamsLiveData()
//            }
//
//            override fun onFailure(call: Call<laptop_listItem>, t: Throwable) {
//                Log.d("Homefragment",t.message.toString())
//            }
//        })


        preparePopularItemsRecycleView()
        homeMvvm.getPopularItems()
        observePopularItemLiveData()
        onPopularItemClick()

        prepareCategoriesRecycleView()
        homeMvvm.getCategories()
        observeCategoriesLiveData()

        prepareCategoriesRecycleView()


    }

    private fun prepareCategoriesRecycleView() {
        categoriesAdapter = CategoriesAdapter()
        binding.recViewCategory.apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            adapter = categoriesAdapter

        }
    }

    private fun observeCategoriesLiveData() {
        homeMvvm.observeCategoriesLiveData().observe(viewLifecycleOwner,Observer{ categories ->
            categoriesAdapter.setCategoryList(categories)


        })
    }

    private fun onPopularItemClick() {
        popularItemAdapter.onItemClick = { meal ->
            val intent = Intent(activity, Meal::class.java)
            intent.putExtra(Laptop_ID,randomLaptop.id)
            intent.putExtra(Laptop_NAME,randomLaptop.nameProducts)
            intent.putExtra(Laptop_Image,randomLaptop.imageSource)
            startActivity(intent)
        }
    }

    private fun observePopularItemLiveData() {
        homeMvvm.observerPopularItemsLiveData().observe(viewLifecycleOwner
        ) { mealList ->
                popularItemAdapter.setMeals(mealsList = mealList as ArrayList<MealsByCategory>)
        }
    }


    private fun onRandomLaptopClick() {
        binding.imgRandomlLaptopp.setOnClickListener{
            val intent = Intent(activity, LaptopActivity::class.java)
//            intent.putExtra(Laptop_ID,randomLaptop.id)
//            intent.putExtra(Laptop_NAME,randomLaptop.nameProducts)
//            intent.putExtra(Laptop_Image,randomLaptop.imageSource)

            startActivity(intent)
        }
    }


    private fun preparePopularItemsRecycleView(){

        binding.recycleLaptopPopular.apply {
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            adapter = popularItemAdapter
        }
    }







}





