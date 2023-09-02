package com.tiashafidzotulluthfiana.mytecon

import android.R
import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import java.text.DecimalFormat
import com.tiashafidzotulluthfiana.mytecon.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var selectedUnit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val df = DecimalFormat("#.##")//Decimal formatter
        selectedUnit = "Fahrenheit"

        binding.selectType.setOnClickListener() {
            showAlertDialog()

        }

        binding.editInput.addTextChangedListener() {
            val resultText: String
            var inputVal = binding.editInput.text.toString()
            if (inputVal.isNotEmpty()) {
                val doubleInput = inputVal.toDouble()
                val resultText: String

                if (selectedUnit == "Fahrenheit to Celcius") {
                    // Convert Fahrenheit to Celsius
                    resultText = df.format((doubleInput - 32) * 5 / 9)
                    binding.textResultType.text = "Celsius"
                } else if (selectedUnit == "Fahrenheit to Reamur") {
                    // Convert Fahrenheit to Reamur
                    resultText = df.format((doubleInput - 32) * 4 / 9)
                    binding.textResultType.text = "Reamur"
                } else if (selectedUnit == "Fahrenheit to Kelvin") {
                    // Convert Fahrenheit to Kelvin
                    resultText = df.format((doubleInput - 32) * 5 / 9 + 273.15)
                    binding.textResultType.text = "Kelvin"
                } else if (selectedUnit == "Celsius to Fahrenheit") {
                    // Convert Celsius to Fahrenheit
                    resultText = df.format(doubleInput * 9 / 5 + 32)
                    binding.textResultType.text = "Fahrenheit"
                } else if (selectedUnit == "Celsius to Reamur") {
                    // Convert Celsius to Reamur
                    resultText = df.format(doubleInput * 4 / 5)
                    binding.textResultType.text = "Reamur"
                } else if (selectedUnit == "Celsius to Kelvin") {
                    // Convert Celsius to Kelvin
                    resultText = df.format(doubleInput + 273.15)
                    binding.textResultType.text = "Kelvin"
                } else if (selectedUnit == "Reamur to Fahrenheit") {
                    // Convert Reamur to Fahrenheit
                    resultText = df.format((doubleInput * 9 / 4) + 32)
                    binding.textResultType.text = "Fahrenheit"
                } else if (selectedUnit == "Reamur to Celsius") {
                    // Convert Reamur to Celsius
                    resultText = df.format(doubleInput * 5 / 4)
                    binding.textResultType.text = "Celsius"
                } else if (selectedUnit == "Reamur to Kelvin") {
                    // Convert Reamur to Kelvin
                    resultText = df.format((doubleInput * 5 / 4) + 273.15)
                    binding.textResultType.text = "Kelvin"
                } else if (selectedUnit == "Kelvin to Fahrenheit") {
                    // Convert Kelvin to Fahrenheit
                    resultText = df.format((doubleInput - 273.15) * 9 / 5 + 32)
                    binding.textResultType.text = "Fahrenheit"
                } else if (selectedUnit == "Kelvin to Celsius") {
                    // Convert Kelvin to Celsius
                    resultText = df.format(doubleInput - 273.15)
                    binding.textResultType.text = "Celsius"
                } else {
                    // Convert Kelvin to Reamur
                    resultText = df.format((doubleInput - 273.15) * 4 / 5)
                    binding.textResultType.text = "Reamur"
                }
                binding.textResult.text = resultText
            }

        }

    }

    private fun showAlertDialog() {
        val alertDialog: Builder = Builder(this@MainActivity)
        alertDialog.setTitle("Select Unit") //Setting title for alertBox
        val items = arrayOf(
            "Fahrenheit to Celcius",
            "Fahrenheit to Reamur",
            "Fahrenheit to Kelvin",
            "Celcius to Fahrenheit",
            "Celcius to Reamur",
            "Celcius to Kelvin",
            "Reamur to Fahrenheit",
            "Reamur to Celcius",
            "Reamur to Kelvin",
            "Kelvin to Fahrenheit",
            "Kelvin to Celcius",
            "Kelvin to Reamur")
        val checkedItem = -1
        alertDialog.setSingleChoiceItems(items, checkedItem,
            DialogInterface.OnClickListener { dialog, which ->
                selectedUnit = items[which]
                binding.textType.setText(items[which])
            })
        alertDialog.setPositiveButton(
            R.string.ok,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
}