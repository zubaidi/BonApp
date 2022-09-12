package com.example.bonapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengeluaran")
data class PengeluaranData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nama_pengeluaran")
    val nama_pengeluaran: String?,
    @ColumnInfo(name = "tanggal")
    val tanggal_pengeluaran: String?,
    @ColumnInfo(name = "jumlah")
    val jumlah_pengeluaran: Int,
    @ColumnInfo(name = "keterangan")
    val keterangan: String?
)
