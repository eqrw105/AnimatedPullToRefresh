package com.nims.animatedpulltorefresh

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipeRefreshLayout = findViewById<LottiePullToRefreshLayout>(R.id.sw)
        swipeRefreshLayout.refreshes()
            .subscribe {
            Toast.makeText(this, "Refreshing Data", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                swipeRefreshLayout.stopRefreshing()
            }, 2000)
        }
        swipeRefreshLayout.onProgressListener {
            Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
        }

    }
}