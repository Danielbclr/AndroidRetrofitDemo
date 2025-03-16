package com.example.retrofitdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var tvResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        tvResponse = findViewById(R.id.tvResponse)

        findViewById<Button>(R.id.btnSingleton).setOnClickListener { fetchData(ApiClient.instance.getSingleton()) }
        findViewById<Button>(R.id.btnPrototype).setOnClickListener { fetchData(ApiClient.instance.getPrototype()) }
        findViewById<Button>(R.id.btnRequest).setOnClickListener { fetchData(ApiClient.instance.getRequest()) }
        findViewById<Button>(R.id.btnSession).setOnClickListener { fetchData(ApiClient.instance.getSession()) }
        findViewById<Button>(R.id.btnApplication).setOnClickListener { fetchData(ApiClient.instance.getApplication()) }

    }

    private fun fetchData(call: Call<String>) {
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                tvResponse.text = response.body() ?: "No response"
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                tvResponse.text = "Error: ${t.message}"
            }
        })
    }
}
