package com.udacity.shoestore.features.shoeDetail.view

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.data.BaseFragment
import com.udacity.shoestore.data.NavigationCommand
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.features.main.viewModel.MainViewModel
import com.udacity.shoestore.utils.AppSharedMethods.getCompatColor
import com.udacity.shoestore.utils.AppSharedMethods.getCompatColorStateList
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoeDetailFragment : BaseFragment() {

    private lateinit var mBinding: FragmentShoeDetailBinding

    private val mSharedViewModel: MainViewModel by inject()
    override val mViewModel: ShoeDetailViewModel by viewModel()

    private lateinit var mActivity: FragmentActivity

    private lateinit var mLifecycleOwner: LifecycleOwner


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentActivity) {
            mActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        mSharedViewModel.setHideToolbar(false)
        mSharedViewModel.showUpButton(true)
        mLifecycleOwner = viewLifecycleOwner
        mBinding.lifecycleOwner = this
        mBinding.shoeDetailViewModel = mViewModel
        initViewModelObserver()
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initViewModelObserver() {

        with(mBinding){
            mViewModel.onProcessSaveShoe.observe(mLifecycleOwner) {
                if (it != null) {
                    mSharedViewModel.addShoe(it)
                    mSharedViewModel.navigationCommand.value = NavigationCommand.Back
                }
            }

            mViewModel.onCancelClick.observe(mLifecycleOwner) {
                if (it) {
                    mSharedViewModel.navigationCommand.value = NavigationCommand.Back
                }
            }

            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    mViewModel.isSaveButtonEnabledStateFlow.collect { isEnabled ->
                        saveButton.backgroundTintList = if (isEnabled) {
                            mActivity.getCompatColorStateList(R.color.colorAccent)
                        } else {
                            mActivity.getCompatColorStateList(R.color.colorGrayF2)
                        }

                        saveButton.strokeColor = if (isEnabled) {
                            mActivity.getCompatColorStateList(R.color.colorAccent)
                        } else {
                            mActivity.getCompatColorStateList(R.color.colorGray63)
                        }

                        saveButton.setTextColor(
                            if (isEnabled) {
                                mActivity.getCompatColor(R.color.colorWhite)
                            } else {
                                mActivity.getCompatColor(R.color.colorBlack)
                            }
                        )
                    }
                }
            }
        }

    }

}