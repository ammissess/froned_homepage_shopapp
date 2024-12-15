package com.example.easylaptopapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.example.easylaptopapp.R
import com.example.easylaptopapp.databinding.ActivityLaptopBinding
import com.example.easylaptopapp.fragments.HomeFragment
import com.example.easylaptopapp.myretrofit.ProductService
import com.example.easylaptopapp.myretrofit.RetrofitInstancee
import com.example.easylaptopapp.myretrofit.albums
import retrofit2.Response

class LaptopActivity : AppCompatActivity() {

    private lateinit var laptopID: String
    private lateinit var laptopName: String
    private lateinit var laptopImage: String

    private lateinit var binding: ActivityLaptopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaptopBinding.inflate(layoutInflater)
        // enableEdgeToEdge()
        setContentView(binding.root)
//
//        getLaptopImformationFromInternet()
//
        getInformationInView()

        val retrofitService =
            RetrofitInstancee.getRetrofitInstance().create(ProductService::class.java)

        val responseLiveData: LiveData<Response<albums>> =
            liveData {
                val response = retrofitService.getProducts()
                emit(response)
            }

        // ten san pham trang to nhat
        responseLiveData.observe(this, Observer {
            val productList = it.body()?.listIterator()
            if (productList != null && productList.hasNext()) {
                val firstProduct = productList.next() // Lấy sản phẩm đầu tiên
                val productTitle = "${firstProduct.shortNameProducts}\n"
                val chitietcauhinh = "${firstProduct.deltials}\n"
                val giasanpham = "${firstProduct.priceUnit}\n"

                binding.collapingToolbar.title = productTitle // Gán giá trị cho TextView
                binding.textthongso.text = chitietcauhinh
                binding.giasanphamTxt.text = giasanpham
            }
        })
    }

    private fun getInformationInView() {
//        Glide.with(applicationContext)
        Glide.with(this@LaptopActivity)
            .load("https://laptopmedia.com/wp-content/uploads/2023/09/acer-nitro-v-15-anv15-51-non-fingerprint-with-backlit-black-05.tif-custom-scaled-e1695938821469.jpg")
            .fitCenter()
            .into(binding.imgMealDeltials)
        // binding.collapingToolbar.title = laptopName ????

    }
//    private fun getLaptopImformationFromInternet() {
//        val intent = intent
//        laptopID = intent.getStringExtra(HomeFragment.Laptop_ID)!!
//        laptopName = intent.getStringExtra(HomeFragment.Laptop_NAME)!!
//        laptopImage = intent.getStringExtra(HomeFragment.Laptop_Image)!!
//    }
}
