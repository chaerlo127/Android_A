package com.example.week8_umc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week8_umc.databinding.ActivityMainBinding

data class BusinessCard(val name:String, val contents: String, var isSwitched: Boolean = false)

class MainActivity : AppCompatActivity() {

    var businessCardArrayList = ArrayList<BusinessCard>()




    // 어댑터 작성한 것을 ListView에 세팅해줘야 함.
    private lateinit var customAdapter:CustomAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        for(x in 0..30){
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
        }

        
        customAdapter = CustomAdapter(this, businessCardArrayList)
        // 리스트 뷰에 어댑터 넣어주기
        binding.listView.adapter = customAdapter

        // RV로 이동하기
        binding.btnRv.setOnClickListener{
            val intent = Intent(this, RVActivity::class.java)
            startActivity(intent)
        }

        binding.btnMemo.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
        }
    }
}