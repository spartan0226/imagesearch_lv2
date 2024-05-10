package com.sparta.fifth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import com.sparta.fifth.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.let {
            binding.btnSearch.setOnClickListener {
                setFragment(ImageSearchFragment())
            }
            binding.btnMark.setOnClickListener {
                setFragment(MyImagesFragment())
            }
            setFragment(ImageSearchFragment())
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frag_main, fragment)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}