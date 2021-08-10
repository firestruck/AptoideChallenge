package com.dmanlancers.aptoide.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmanlancers.aptoide.R
import com.dmanlancers.aptoide.databinding.FragmentAptoideBinding
import com.dmanlancers.aptoide.domain.model.ListValues
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AptoideFragment : Fragment(), ListAction {

    private var _binding: FragmentAptoideBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AptoideViewModel by viewModels()
    private var topRecyclerAdapter: TopRecyclerAdapter? = null
    private var bottomRecyclerAdapter: BottomRecyclerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.loadApps()

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_navigation_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAptoideBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        observeViewModel()


        return binding.root
    }

    private fun observeViewModel() {

        viewModel.isLoad.observe(viewLifecycleOwner, { isLoad ->
            isLoad?.let { view ->

                binding.topRecyclerProgressBar.visibility = if (view) View.GONE else View.VISIBLE

            }

        })

        viewModel.appsReceivedLiveData.observe(viewLifecycleOwner, { appList ->

            appList?.let {

                val allAppsList = it.responses.listApps.datasets.all.data.list

                Timber.e("valor: %s", it)


                initRecycler(allAppsList)


            }
        })


    }

    private fun initRecycler(appList: List<ListValues>) {


        binding.topRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.bottomRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        topRecyclerAdapter = TopRecyclerAdapter(appList, this)
        bottomRecyclerAdapter = BottomRecyclerAdapter(appList, this)

        binding.topRecycler.adapter = topRecyclerAdapter
        binding.bottomRecycler.adapter = bottomRecyclerAdapter


    }




    override fun onClick(position: Int) {
        TODO("No action needed for this challenge")
    }


}