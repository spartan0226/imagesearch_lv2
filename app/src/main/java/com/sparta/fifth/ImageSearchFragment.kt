package com.sparta.fifth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sparta.fifth.databinding.FragmentImageSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ImageSearchFragment : Fragment() {

    private val binding by lazy {
        FragmentImageSearchBinding.inflate(layoutInflater)
    }

//    private var likedItems: MutableSet<String> = mutableSetOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerviewAdapter()
        binding.rvSearch.apply {
            layoutManager = GridLayoutManager(activity, 2)
            this.adapter = adapter
        }

        val setSearched = SharedPreferences.setSearched(requireContext())
        binding.etSearch.setText(setSearched)

        binding.btnRealSearch.setOnClickListener {
            val searchWord = binding.etSearch.text.toString()
            SharedPreferences.gotSearched(requireContext(), searchWord) //검색어 저장

            val hidden =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hidden.hideSoftInputFromWindow(binding.search.windowToken, 0)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImageSearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

