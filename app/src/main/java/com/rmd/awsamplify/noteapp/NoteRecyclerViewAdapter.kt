package com.rmd.awsamplify.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rmd.awsamplify.noteapp.databinding.ContentNoteBinding

// this is a single cell (row) in the list of Notes
class NoteRecyclerViewAdapter(
    private val values: MutableList<UserData.Note>?
) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding: ContentNoteBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        binding = ContentNoteBinding.bind(holder.itemView)

        val item = values?.get(position)
        binding.name.text = item?.name
        binding.description.text = item?.description

        if (item?.image != null) {
            binding.image.setImageBitmap(item.image)
        }
    }

    override fun getItemCount() = values?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}