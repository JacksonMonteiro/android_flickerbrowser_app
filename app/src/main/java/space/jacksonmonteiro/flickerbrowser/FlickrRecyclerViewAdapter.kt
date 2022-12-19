package space.jacksonmonteiro.flickerbrowser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//
// Created by Jackson Monteiro on 13/12/2022
//

class FlickrRecyclerViewAdapter(private var photoList : List<Photo>) : RecyclerView.Adapter<FlickrImageViewHolder>() {
    private val TAG = "FlickrRecyclerViewAdapt"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickrImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse, parent, false)
        return FlickrImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlickrImageViewHolder, position: Int) {

        if (photoList.isEmpty()) {
            holder.thumbnail.setImageResource(R.drawable.ic_placeholder)
            holder.title.setText(R.string.empty_photo)
        } else {
            val photoItem = photoList[position]
            Picasso.get().load(photoItem.image)
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.thumbnail)

            holder.title.text = photoItem.title
        }

    }

    override fun getItemCount(): Int {
        return if (photoList.isNotEmpty()) photoList.size else 1
    }

    fun loadNewData(newPhotos: List<Photo>){
        photoList = newPhotos
        notifyDataSetChanged()
    }

    fun getPhoto(position: Int) : Photo? {
        return if (photoList.isNotEmpty()) photoList[position] else null
    }
}

class FlickrImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var thumbnail:  ImageView = view.findViewById(R.id.thumbnail)
    var title: TextView = view.findViewById(R.id.photo_title)
}