package com.zamzam.helloworld

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zamzam.helloworld.databinding.ListItemBinding

class MainAdapter(private val data: List<Hewan>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hewan: Hewan) = with(binding) {
            imageView.setImageResource(hewan.gambarResId)
            textView.text = hewan.nama
            textView2.text = hewan.namaLatin

            root.setOnClickListener {
                val msg = root.context.getString(R.string.x_diklik, hewan.nama)
                Toast.makeText(root.context, msg, Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((data[position]))
    }

    override fun getItemCount() = data.size
}