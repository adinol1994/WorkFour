package com.example.workfour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.workfour.databinding.NoteListItemBinding
import com.squareup.picasso.Picasso
import java.text.FieldPosition

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {
    var items: List<Note> = mutableListOf()
    set(value) {
        notifyDataSetChanged()

    }
    private var itemClick: (Note) -> Unit = {}
    fun itemClik(listener: (Note) -> Unit) {
        itemClick = listener

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.note = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
            Picasso.get().load(items[position].img).into((holder.binding.imageView3))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = NoteListItemBinding.bind(view)
    }
}
