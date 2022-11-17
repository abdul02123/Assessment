package com.app.android.techassessment.ui.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.android.techassessment.databinding.ItemArticleAdapterBinding
import com.app.android.techassessment.model.Result

class ArticleAdapter(private val articles: List<Result>, private val articleClicked : (Result) -> Unit): RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = ItemArticleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = articles[position]
        holder.onBind(article)

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    inner class MyViewHolder(private val binding: ItemArticleAdapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(article: Result){
//            Glide.with(context).load(article.url).into(binding.profileImage)
            binding.tvTitle.text = article.title
            binding.tvSubTitle.text = article.byline
            binding.tvDate.text = article.published_date
            binding.root.setOnClickListener {
                articleClicked(article)
            }
        }

    }
}