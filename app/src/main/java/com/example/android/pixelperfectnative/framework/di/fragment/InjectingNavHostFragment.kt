package com.example.android.pixelperfectnative.framework.di.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.example.android.pixelperfectnative.framework.PixelPerfectApplication
import javax.inject.Inject

class InjectingNavHostFragment : NavHostFragment() {
    @Inject
    protected lateinit var daggerFragmentInjectionFactory: FragmentFactory

    override fun onAttach(context: Context) {
        PixelPerfectApplication.component.getFragmentComponent()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        childFragmentManager.fragmentFactory = daggerFragmentInjectionFactory
        super.onCreate(savedInstanceState)
    }
}
