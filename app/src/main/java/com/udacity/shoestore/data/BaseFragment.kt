package com.udacity.shoestore.data

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.utils.AppSharedMethods
import com.udacity.shoestore.utils.AppSharedMethods.showToast
import com.udacity.shoestore.utils.ShoeStoreApp
import timber.log.Timber

/**
 * Base Fragment to observe on the common LiveData objects
 */
abstract class BaseFragment : Fragment() {

    /**
     * Every fragment has to have an instance of a view model that extends from the BaseViewModel
     */
    abstract val mViewModel: BaseViewModel

    private lateinit var mActivity: FragmentActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentActivity) {
            mActivity = context
        }
    }

    override fun onStart() {
        super.onStart()

        mViewModel.showErrorMessage.observe(viewLifecycleOwner) {
            showToast(it)
        }
        mViewModel.showToast.observe(viewLifecycleOwner) {
            showToast(it)
        }
        mViewModel.showSnackBar.observe(viewLifecycleOwner) {
            Snackbar.make(this.requireView(), it, Snackbar.LENGTH_LONG).show()
        }
        mViewModel.showSnackBarInt.observe(viewLifecycleOwner) {
            Snackbar.make(this.requireView(), mActivity.getString(it), Snackbar.LENGTH_LONG).show()
        }

        mViewModel.showToastInt.observe(viewLifecycleOwner) {
            showToast(getString(it))
        }

        mViewModel.showLoading.observe(viewLifecycleOwner) {
            if (it) {
                showWaiteDialog()
            } else {
                hideWaiteDialog()
            }
        }

    }


    private fun showWaiteDialog() {

    }

    private fun hideWaiteDialog() {

    }
}