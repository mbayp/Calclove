package com.example.calclove.onBoarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calclove.R
import com.example.calclove.databinding.ItemOnboardingBinding
import com.squareup.picasso.Picasso

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoardingModel(
            R.raw.lottie_anim1,
            "love",
            "Desc"
        ),
        OnBoardingModel(
            R.raw.lottie_anim2,
            " love",
            "Desc "
        ),
        OnBoardingModel(
            R.raw.lottie_anim3,
            "love ",
            "Desc"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingAdapter.OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoardingModel) {
            onBoarding.anim?.let {
                binding.animBoard.setAnimation(onBoarding.anim)
                binding.animBoard.playAnimation()
            }
            binding.tvBoard.text = onBoarding.title
            binding.tvBdTitle.text = onBoarding.description
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }

}