//Adapter가 뭐였지? data와 raw item틀을 묶어주는 애.

package com.example.week4_recyclerview_profile_hw

import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_recyclerview_profile_hw.databinding.ItemBizcardBinding

class BizCardAdapter(
    val list : List<BizCard>,
    //val newlist = arrayListOf<>(),
    val context : Context
) : RecyclerView.Adapter<BizCardAdapter.BusinessViewHolder>() {

    private val checkboxStatus = SparseBooleanArray()

    inner class BusinessViewHolder(val binding: ItemBizcardBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(item: BizCard) = with(binding){
            profileImg.setImageDrawable(ContextCompat.getDrawable(context, item.img))
            company.text = item.company
            name.text = item.name
            phoneNum.text = item.phoneNum
            checkBox.isChecked = checkboxStatus[adapterPosition]

            checkBox.setOnClickListener{
                if(!checkBox.isChecked)
                    checkboxStatus.put(adapterPosition, false)
                else
                    checkboxStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }
        }
    }


    //보이는 몇 개만 만들어주는 애. 처음 몇 개만 만들고 그 이후는 재활용(로그 찍어보면 앎)
    //얘를 하려면 우리가 만든 xml을 메모리에 올려주어야 함.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val view = ItemBizcardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessViewHolder(view)
    }

    //viewholder에다가 data를 bind시키는 것.
    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //알아서 list.size.를 하면 알아서 count 해줌.
    override fun getItemCount(): Int {
        return list.size
    }

}
