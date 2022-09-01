package com.zamzam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Jumlah data: ${getData().size}")

    }

    private fun getData(): List<Hewan> {
        return listOf(
            Hewan("Angsa"   , "Cygnus olor"             , R.drawable.angsa),
            Hewan("Ayam"    , "Gallus Gallus"           , R.drawable.ayam),
            Hewan("Bebek"   , "Cairina moschata"        , R.drawable.bebek),
            Hewan("Domba"   , "Ovis ammon"              , R.drawable.domba),
            Hewan("Kalkun"  , "Meleagris gallopavo"     , R.drawable.kalkun),
            Hewan("Kambing" , "Capricornis sumatrensis" , R.drawable.kambing),
            Hewan("Kelinci" , "Oryctolagus cuniculus"   , R.drawable.kelinci),
            Hewan("Kerbau"  , "Bubalus bubalis"         , R.drawable.kerbau),
            Hewan("Kuda"    , "Equus caballus"          , R.drawable.kuda),
            Hewan("Sapi"    , "Bos taurus"              , R.drawable.sapi),
        )
    }
}