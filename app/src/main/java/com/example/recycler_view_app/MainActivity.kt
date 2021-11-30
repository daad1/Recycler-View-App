package com.example.recycler_view_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var btnSubmit: Button? = null
    var edEntertext: EditText? = null
    var items = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewConnected()

    }

    private fun viewConnected() {

        btnSubmit = findViewById<Button>(R.id.btnAdd)
        edEntertext = findViewById(R.id.edInput)
        btnSubmit?.setOnClickListener {
            if (edInput.text.isEmpty() || edInput.text.toString() == "") {

                Snackbar.make(cl, "Empty Field, Please Enter Text", Snackbar.LENGTH_SHORT).show()
            } else
                items?.add(edInput.text.toString())

            var theRecyclerView = findViewById<RecyclerView>(R.id.rvMain)

            theRecyclerView.adapter = RecyclerViewAdapter(items)
            theRecyclerView.layoutManager = LinearLayoutManager(this)

            edInput.text.clear()

            Log.d("MainActivity", items.toString())
        }
    }

}