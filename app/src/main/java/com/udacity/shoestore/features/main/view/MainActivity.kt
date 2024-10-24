package com.udacity.shoestore.features.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.data.NavigationCommand
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.features.main.viewModel.MainViewModel
import com.udacity.shoestore.utils.AppSharedData
import com.udacity.shoestore.utils.AppSharedMethods
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mMainViewModel: MainViewModel by inject()

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mNavController: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(mBinding.mainToolbar)
        mBinding.mainToolbar.setTitle(null)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController
        mAppBarConfiguration = AppBarConfiguration(mNavController.graph)

        if (savedInstanceState == null){
            val navInflater = mNavController.navInflater
            val navGraph = navInflater.inflate(R.navigation.main_navigation)
            navGraph.setStartDestination(
                if (AppSharedMethods.isLogin()) {
                    R.id.shoesListFragment
                } else {
                    R.id.loginFragment
                }
            )
            mNavController.graph = navGraph
        }

        initViewModelObservers()

    }

    private fun initViewModelObservers() {

        with(mBinding) {
            mMainViewModel.hideToolbar.observe(this@MainActivity) {
                if (it) {
                    mainToolbar.visibility = View.GONE
                } else {
                    mainToolbar.visibility = View.VISIBLE
                }
            }
            mMainViewModel.toolbarTitle.observe(this@MainActivity) {
                textViewToolbarTitle.text = it
            }

            mMainViewModel.showUpButton.observe(this@MainActivity) {
                supportActionBar!!.setDisplayHomeAsUpEnabled(it)
            }

            mMainViewModel.navigationCommand.observe(this@MainActivity) { command ->

                Timber.d("initViewModelObserver:command: " + command.toString())

                when (command) {
                    is NavigationCommand.To -> mNavController.navigate(command.directions)
                    is NavigationCommand.Back -> mNavController.popBackStack()
                    is NavigationCommand.BackTo -> mNavController.popBackStack(
                        command.destinationId, false
                    )
                }
            }
        }

        with(mMainViewModel) {

            showToast.observe(this@MainActivity) {
                AppSharedMethods.showToast(it)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration)
    }

    override fun onClick(view: View?) {

    }
}
