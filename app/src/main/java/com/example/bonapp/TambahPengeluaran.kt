package com.example.bonapp

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.bonapp.databinding.ActivityTambahPengeluaranBinding
import java.text.NumberFormat
import java.util.*

class TambahPengeluaran : AppCompatActivity() {

    private lateinit var tpBind: ActivityTambahPengeluaranBinding
    var tanggal: String = ""
    var title:String = ""
    var value = ""
    var desc:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengeluaran)
        tpBind = ActivityTambahPengeluaranBinding.inflate(layoutInflater)
        val view = tpBind.root
        setContentView(view)
        setKategoriPengeluaran()
        setBackMenu()
        setDatePengeluaran()
        simpanData()
    }

    private fun simpanData() {
        tpBind.btnSimpan.setOnClickListener {
            tanggal = tpBind.txtTanggal.text.toString()
            title = tpBind.txtNamaPengeluaran.text.toString()
            value = tpBind.txtJumlah.text.toString()
            desc = tpBind.spinKeterangan.selectedItem.toString()
            val setValue = if (value.isNotEmpty()){
                value.toString().toInt()
            } else {
                0
            }
            Log.d(
                "hasil:",
                "${tanggal+" "+title+" "+setValue+" "+desc}"
            )
        }
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