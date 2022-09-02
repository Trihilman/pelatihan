package com.zamzam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.zamzam.helloworld.database.Diary
import com.zamzam.helloworld.database.DiaryDb
import com.zamzam.helloworld.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by lazy {
        val db = DiaryDb.getInstanse(this)
        val factory = DetailViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[DetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuSimpan) {
            insertDiary()
            return true
        }
        return false
    }

    private fun insertDiary() {
        val judul = binding.etJudul.text.toString()
        if (TextUtils.isEmpty(judul)) {
            Toast.makeText(this, getString(R.string.message_judul), Toast.LENGTH_SHORT).show()
            return
        }
        val diary = binding.etDiary.text.toString()
        if (TextUtils.isEmpty(diary)) {
            Toast.makeText(this, getString(R.string.message_diary), Toast.LENGTH_SHORT).show()
            return
        }
        val data = Diary(judul = judul, diary = diary)
        viewModel.insertDiary(data)
        finish()
    }
}