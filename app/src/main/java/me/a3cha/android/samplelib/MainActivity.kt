package me.a3cha.android.samplelib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.a3cha.android.smartprogressdialog.SmartProgressDialog

class MainActivity : AppCompatActivity() {
    private val progressDialog: SmartProgressDialog by lazy { SmartProgressDialog.Builder().setMessage("Loading jaa...").build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowDialog.setOnClickListener {
            if (!progressDialog.isVisible) {
                progressDialog.show(supportFragmentManager, "dialog")
            }
        }
    }

    override fun onDestroy() {
        if (progressDialog.isVisible) {
            progressDialog.dismiss()
        }
        super.onDestroy()
    }
}
