package com.app.android.techassessment.ui.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.app.android.techassessment.R
import com.app.android.techassessment.databinding.FragmentArticlesBinding
import com.app.android.techassessment.model.Result
import com.app.android.techassessment.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArticleAdapter

    @Inject
    lateinit var articleViewModel: ArticleViewModel
    private var isArticleCalled: Boolean  = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
    }

    override fun onResume() {
        super.onResume()
        if (!isArticleCalled){
            isArticleCalled = true
            articleViewModel.getAllArticles()
        }
    }

    private fun bindObserver(){
        articleViewModel.articleResponseData.observe(viewLifecycleOwner, {
            binding.progressBar.visibility = View.GONE
            binding.tvError.visibility = View.GONE
            when (it) {
                is NetworkResult.Success -> {
                    it.data?.apply {
                        populateArticles(results)
                    }
                }
                is NetworkResult.Error -> {
                    binding.tvError.visibility = View.VISIBLE
                }
                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun populateArticles(articles: List<Result>){
        adapter = ArticleAdapter(articles, :: articleClicked)
        binding.recyclerView.adapter = adapter
    }

    private fun articleClicked(article: Result){
        val action = ArticlesFragmentDirections.actionArticlesFragmentToArticleDetailFragment(article)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}