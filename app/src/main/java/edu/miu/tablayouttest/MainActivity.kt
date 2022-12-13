package edu.miu.tablayouttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.miu.tablayouttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addRow("Android 8.0", "Oreo")
        addRow("Android 9.0", "Pie")

        binding.btnAdd.setOnClickListener {
            addRow(
                binding.etAndroidVersion.text.toString().trim(),
                binding.etAndroidCodeNm.text.toString().trim()
            )
        }

    }

    @SuppressLint("ResourceType")
    private fun addRow(versionName: String, codeName: String) {
        val tableRow = TableRow(this)
        val textViewVersion = TextView(this)
        textViewVersion.text = versionName

        val textViewCodeName = TextView(this)
        textViewCodeName.text = codeName

        tableRow.addView(textViewVersion, 0)
        tableRow.addView(textViewCodeName, 1)

        val textViewVersionParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 8, 12, 0)
        }

        textViewVersionParams.weight = 2f

        textViewVersion.setBackgroundResource(R.color.table_row_bg)
        textViewVersion.layoutParams = textViewVersionParams

        val tvCodeNameParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 4, 0, 0)
        }
        tvCodeNameParam.weight = 2f
        textViewCodeName.setBackgroundResource(R.color.table_row_bg)
        textViewCodeName.layoutParams = tvCodeNameParam

        binding.androidTable.addView(tableRow)
    }
}