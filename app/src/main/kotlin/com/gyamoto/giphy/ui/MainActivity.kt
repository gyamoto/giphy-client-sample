package com.gyamoto.giphy.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.gyamoto.giphy.R
import com.gyamoto.giphy.ui.random.RandomActivity
import com.gyamoto.giphy.ui.trend.TrendActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActivityInjector {

    override val injector: KodeinInjector = KodeinInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        setContentView(R.layout.activity_main)

        trend.setOnClickListener {
            TrendActivity.start(this)
        }

        random.setOnClickListener {
            RandomActivity.start(this)
        }

        search.setOnClickListener {
            Snackbar.make(container, R.string.search, Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
