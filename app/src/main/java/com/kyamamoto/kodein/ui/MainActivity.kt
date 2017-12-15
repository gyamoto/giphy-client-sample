package com.kyamamoto.kodein.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.kyamamoto.kodein.R
import com.kyamamoto.kodein.ui.trend.TrendActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trend.setOnClickListener {
            TrendActivity.start(this)
        }

        random.setOnClickListener {
            Snackbar.make(container, R.string.random, Snackbar.LENGTH_SHORT).show()
        }

        search.setOnClickListener {
            Snackbar.make(container, R.string.search, Snackbar.LENGTH_SHORT).show()
        }
    }
}
