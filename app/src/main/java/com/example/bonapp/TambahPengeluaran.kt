package com.example.bonapp

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.bonapp.databinding.ActivityTambahPengeluaranBinding
import java.text.NumberFormat
import java.util.*

class TambahPengeluaran : AppCompatActivity() {

    private lateinit var tpBind: ActivityTambahPengeluaranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengeluaran)
        tpBind = ActivityTambahPengeluaranBinding.inflate(layoutInflater)
        val view = tpBind.root
        setContentView(view)
        setKategoriPengeluaran()
        setBackMenu()
        setDatePengeluaran()
        //format rupiah
        tpBind.txtJumlah.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun setDatePengeluaran() {
        tpBind.txtTanggal.setOnClickListener {
            var cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { picker, tahun, bulan, tanggal ->
                tpBind.txtTanggal.setText(""+tanggal+"-"+bulan+"-"+tahun)
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun setBackMenu() {
        tpBind.backMenu.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setKategoriPengeluaran() {
        ArrayAdapter.createFromResource(
            this, R.array.kategori_pengeluaran, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            tpBind.spinKeterangan.adapter = adapter
        }
    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}