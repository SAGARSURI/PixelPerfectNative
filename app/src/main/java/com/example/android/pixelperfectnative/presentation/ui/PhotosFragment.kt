package com.example.android.pixelperfectnative.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.core.utils.ViewState
import com.example.android.pixelperfectnative.R
import com.example.android.pixelperfectnative.databinding.PhotosFragmentBinding
import com.example.android.pixelperfectnative.presentation.utils.shareImage
import kotlinx.android.synthetic.main.photos_fragment.*
import javax.inject.Inject

class PhotosFragment @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : Fragment() {

    private val viewModel: PhotosViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(PhotosViewModel::class.java)
    }

    private val photosAdapter: PhotosAdapter by lazy { PhotosAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return PhotosFragmentBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = this@PhotosFragment
                vm = viewModel
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()

        photosRecyclerView.apply {
            adapter = photosAdapter
            setHasFixedSize(true)
        }

        photosAdapter.itemAction = {
            it.shareImage(this)
        }

        observeLiveData()
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.app_name)
        toolbar.inflateMenu(R.menu.actions)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.darkMode -> Log.e("PhotosFragment", "menu clicked")
                else -> return@setOnMenuItemClickListener false
            }
            true
        }
    }

    private fun observeLiveData() {
        viewModel.photosLiveData.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is ViewState.Loading -> {
                        progressBar.visibility = View.VISIBLE
                        photosRecyclerView.visibility = View.INVISIBLE
                    }
                    is ViewState.Success -> {
                        photosAdapter.updatePhotoList(it.result)
                        progressBar.visibility = View.GONE
                        photosRecyclerView.visibility = View.VISIBLE
                    }
                    is ViewState.Error -> {
                        progressBar.visibility = View.GONE
                        photosRecyclerView.visibility = View.INVISIBLE
                        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}
