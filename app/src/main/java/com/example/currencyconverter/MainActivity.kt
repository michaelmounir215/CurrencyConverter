package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(){

    val TAG = "MainActivity"
    private val EGP = "Egyptian Pound (EGP)"
    private val USD = "United States Dollar (USD)"
    private val AED = "Arab Emirates Dirham (AED)"
    private val GBP = "Great Britain Pound (GBP)"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertBtn : Button = findViewById(R.id.convert_button)
        val amountEt : TextInputEditText = findViewById(R.id.amount_edit_text)
        val resultEt : TextInputEditText = findViewById(R.id.result_edit_text)
        val toDropDownMenu : AutoCompleteTextView = findViewById(R.id.to_currency_menu)
        val fromDropDownMenu : AutoCompleteTextView = findViewById(R.id.from_currency_menu)

        val listOfCountry = listOf(EGP, USD, AED, GBP)
        val adapter = ArrayAdapter(this, R.layout.drop_down_list_item, listOfCountry)
        toDropDownMenu.setAdapter(adapter)
        fromDropDownMenu.setAdapter(adapter)

        convertBtn.setOnClickListener {
            val amount = amountEt.text.toString().toDouble()
            val currencyToField = toDropDownMenu.text.toString()
            val currencyFromField = fromDropDownMenu.text.toString()

            var result = 0.0
            if (currencyFromField == EGP && currencyToField == EGP) {
                result = amount
            }else if (currencyFromField == EGP && currencyToField == USD){
                result = amount.times(0.032)
            }else if (currencyFromField == EGP && currencyToField == AED){
                result = amount.times(0.12)
            }else if (currencyFromField == EGP && currencyToField == GBP){
                result = amount.times(0.026)
            }else if (currencyFromField == USD && currencyToField == USD){
                result = amount
            }else if (currencyFromField == USD && currencyToField == EGP){
                result = amount.times(30.90)
            }else if (currencyFromField == USD && currencyToField == AED){
                result = amount.times(3.67)
            }else if (currencyFromField == USD && currencyToField == GBP){
                result = amount.times(0.79)
            }else if (currencyFromField == AED && currencyToField == AED){
                result = amount
            }else if (currencyFromField == AED && currencyToField == EGP){
                result = amount.times(8.41)
            }else if (currencyFromField == AED && currencyToField == USD){
                result = amount.times(0.027)
            }else if (currencyFromField == AED && currencyToField == GBP){
                result = amount.times(0.022)
            }else if (currencyFromField == GBP && currencyToField == GBP){
                result = amount
            }else if (currencyFromField == GBP && currencyToField == EGP){
                result = amount.times(39.06)
            }else if (currencyFromField == GBP && currencyToField == AED){
                result = amount.times(4.64)
            }else if (currencyFromField == GBP && currencyToField == USD){
                result = amount.times(1.26)
            }
            resultEt.setText(result.toString())
        }
    }
}