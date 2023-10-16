package com.example.shoppingapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val productArrayList: List<Product>) :

    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image : ShapeableImageView
        var description :TextView

        init {
            title = itemView.findViewById(R.id.productName)
            image = itemView.findViewById(R.id.productImage)
            description = itemView.findViewById(R.id.productDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //to create the view holder if the creation of view holder fails
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //for data population
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.description.text= currentItem.description

        //imageview is given the data
        //image is given in form of URL and then show the image, for this we use third party library

        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }


    }
