package com.example.week4_recyclerview_profile_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.week4_recyclerview_profile_hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf<BizCard>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeNewList()
        //adapter 생성
        //val adapter = BizCardAdapter(list, this)

        //recylerView에 연결 시키기
        //binding.rcview.adapter = adapter

        // 바로 넣어줘도 됨.
        // binding.recyclerview.adapter = BizCardAdapter(list, this)

        //binding.rcview.layoutManager = LinearLayoutManager(this)
        binding.rcview.apply {
            adapter = BizCardAdapter(list,this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)

        }

        binding.swipeLayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            list.clear()
            makeNewList()
            print(list.size)
            //list.addAll(arrayListOf<BizCard>())
            Log.d("뭐가 에러일까,,,","에러 나지마 제발,,,")
            binding.swipeLayout.isRefreshing = false

        })
        //setContentView(binding.rcview)
    }

    private fun makeNewList() {
        for (i in 0..20) {
            list.add(BizCard("Apeach", R.drawable.apeach, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Chunsik", R.drawable.chunsik, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Cone", R.drawable.cone, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Frodo", R.drawable.frodo, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("JayZ", R.drawable.jayz, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Muzi", R.drawable.muzi, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Neo", R.drawable.neo, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Tube", R.drawable.tube, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("Zordi", R.drawable.zordi, "카카오프렌즈", "010-0000-0000"))
            list.add(BizCard("ryan", R.drawable.ryan, "카카오프렌즈", "010-0000-0000"))
        }
    }
}