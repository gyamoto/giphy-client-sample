package com.gyamoto.giphy.ui.random

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.gyamoto.giphy.R
import com.gyamoto.giphy.databinding.ActivityRandomBinding
import kotlinx.android.synthetic.main.activity_random.*

class RandomActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, RandomActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRandomBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_random)
        val viewModel = ViewModelProviders.of(this).get(RandomViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        viewModel.random.observe(this, Observer {

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
