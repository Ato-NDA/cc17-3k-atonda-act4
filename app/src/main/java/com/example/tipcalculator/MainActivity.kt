package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var billAmountEditText: EditText
    private lateinit var tipPercentageEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var tipAmountTextView: TextView
    private lateinit var totalAmountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        billAmountEditText = findViewById(R.id.billAmountEditText)
        tipPercentageEditText = findViewById(R.id.tipPercentageEditText)
        calculateButton = findViewById(R.id.calculateButton)
        tipAmountTextView = findViewById(R.id.tipAmountTextView)
        totalAmountTextView = findViewById(R.id.totalAmountTextView)

        // Set click listener for calculate button
        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        // Get bill amount and tip percentage from EditText fields
        val billAmount = billAmountEditText.text.toString().toDoubleOrNull() ?: 0.0
        val tipPercentage = tipPercentageEditText.text.toString().toDoubleOrNull() ?: 15.0

        // Calculate tip and total
        val tipAmount = billAmount * (tipPercentage / 100)
        val totalAmount = billAmount + tipAmount

        // Format results
        val formattedTipAmount = NumberFormat.getCurrencyInstance().format(tipAmount)
        val formattedTotalAmount = NumberFormat.getCurrencyInstance().format(totalAmount)

        // Display results
        tipAmountTextView.text = getString(R.string.tip_amount, formattedTipAmount)
        totalAmountTextView.text = getString(R.string.total_amount, formattedTotalAmount)
    }
}