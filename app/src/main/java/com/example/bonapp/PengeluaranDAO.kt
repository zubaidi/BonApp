package com.example.bonapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PengeluaranDAO {

    @Insert
    fun insertData(pengeluaranData: PengeluaranData)

    @Update
    fun updateData(pengeluaranData: PengeluaranData)

    @Delete
    fun deleteData(pengeluaranData: PengeluaranData)

    @Query("DELETE FROM pengeluaran")
    fun deleteAllData()

    @Query("SELECT * FROM pengeluaran ORDER BY tanggal")
    fun getAllData() : LiveData<ArrayList<PengeluaranData>>

    @Query("SELECT SUM('jumlah') FROM pengeluaran")
    fun getSumPengeluaran()

}