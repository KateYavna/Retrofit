package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.retrofit.network.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            fun refresh() {
                var retrofit =
                    RetrofitClient.getClient("https://api.coindesk.com/").create(API::class.java)
                retrofit.getCurrentPrice().enqueue(object : Callback<ResponseMain> {
                    override fun onResponse(
                        call: Call<ResponseMain>,
                        response: Response<ResponseMain>)
                    {
                        Log.d("MyLog", "response")
                        Log.d("MyLog",response.body()!!.toString() )
                        if (response.body() != null) {
                            tvUSDrate.text = response.body()!!.bpi.USD.rate
                            tvUSDrate_float.text = response.body()!!.bpi.USD.rate_float.toString()
                            tvGBPrate.text = response.body()!!.bpi.GBP.rate.toString()
                            tvGBPrate_float.text = response.body()!!.bpi.GBP.rate_float.toString()
                            tvEURrate.text = response.body()!!.bpi.EUR.rate.toString()
                            tvEURrate_float.text = response.body()!!.bpi.EUR.rate_float.toString()
                            tvTime1.text = response.body()!!.time.updated.toString()
                            tvTime2.text = response.body()!!.time.updatedISO.toString()
                            tvTime3.text = response.body()!!.time.updateduk.toString()

                        }
                    }

                    override fun onFailure(call: Call<ResponseMain>, t: Throwable) {
                        Log.d("MyLog", "failure")
                    }

                })

                tvUSDrate.visibility = View.VISIBLE
                tvUSDrate_float.visibility = View.VISIBLE
                tvGBPrate.visibility = View.VISIBLE
                tvGBPrate_float.visibility = View.VISIBLE
                tvEURrate.visibility = View.VISIBLE
                tvEURrate_float.visibility = View.VISIBLE
                tvTime1.visibility = View.VISIBLE
                tvTime2.visibility = View.VISIBLE
                tvTime3.visibility = View.VISIBLE
             }

        btShow.setOnClickListener { refresh() }
        btRefresh.setOnClickListener { refresh() }

    }
}