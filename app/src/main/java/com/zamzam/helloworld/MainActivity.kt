package com.zamzam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.zamzam.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener { hitung() }
    }

    private fun hitung() {
        val berat = binding.etBerat.text.toString()
        if (TextUtils.isEmpty(berat)){
            Toast.makeText(this,"Berat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }
        val tinggi = binding.etTinggi.text.toString()
        if (TextUtils.isEmpty(tinggi)){
            Toast.makeText(this,"Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1){
            Toast.makeText(this,"Jenis Kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }
        val tinggiCm = tinggi.toFloat() / 100
        val bmi = berat.toFloat() / (tinggiCm * tinggiCm)
        val isMale = selectedId == R.id.rbPria
        val kategori = getKategori(bmi, isMale)
        binding.tvBMI.text = getString(R.string.bmi_x, bmi)
        binding.tvKategori.text = getString(R.string.kategori_x, kategori)
    }

    private fun getKategori(bmi: Float, isMale: Boolean): String {
        val stringRes = if (isMale) {
            when {
                bmi < 20.5 -> R.string.kurus
                bmi >= 27.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        }
        else {
            when {
                bmi < 18.5 -> R.string.kurus
                bmi >= 25.0 -> R.string.gemuk
                else -> R.string.ideal
            }
        }
        return getString(stringRes)
    }
}