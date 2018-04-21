package com.gyamoto.giphy.ui.random

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gyamoto.giphy.R
import com.gyamoto.giphy.architecturecomponent.Resource
import kotlinx.android.synthetic.main.activity_random.*

class RandomActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, RandomActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        val viewModel = ViewModelProviders.of(this).get(RandomViewModel::class.java)
        viewModel.random.observe(this, Observer {

            val isProgress = it?.status == Resource.Companion.Status.Progress

            image.apply {
                Glide.with(this)
                        .load(it?.response?.data?.fixed_width_downsampled_url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(this)
            }

            button.apply {

                val stringResId = if (isProgress) {
                    R.string.random_requesting
                } else {
                    R.string.random_update
                }
                setText(stringResId)

                isClickable = !isProgress
            }

            progress.apply {
                visibility = if (isProgress) View.VISIBLE else View.GONE
            }

            it?.error?.let {
                Snackbar.make(button, it.message.toString(), Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry", { viewModel.updateGif() })
                        .show()
            }

        })

        button.setOnClickListener {
            viewModel.updateGif()
        }

    }
}