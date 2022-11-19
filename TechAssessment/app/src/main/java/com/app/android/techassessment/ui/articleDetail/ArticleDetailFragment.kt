package com.app.android.techassessment.ui.articleDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.app.android.techassessment.R
import com.app.android.techassessment.databinding.FragmentArticleDetailBinding
import com.app.android.techassessment.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailFragment : Fragment() {

    private var _binding: FragmentArticleDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleDetails = args.article
        binding.tvTitle.text = articleDetails.title
        binding.tvDetail.text = articleDetails.abstract
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}