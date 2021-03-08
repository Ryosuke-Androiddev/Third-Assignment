package com.example.ryousuke.thirdassignment.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ryousuke.thirdassignment.R
import com.example.ryousuke.thirdassignment.database.ToDoEntity
import com.example.ryousuke.thirdassignment.databinding.FragmentEditBinding
import com.example.ryousuke.thirdassignment.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditBinding.inflate(layoutInflater,container,false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_edit_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.edit_menu){
            insertDataToDb()
        }
        return super.onOptionsItemSelected(item)
    }

    //save data into Database
    private fun insertDataToDb(){

        val todoTitle = binding.todoTitleEt.text.toString()
        val description = binding.descriptionEt.text.toString()

        val validation = mainViewModel.checkDataFromUser(todoTitle,description)
        if (validation){

            //set data into Database
            val newData = ToDoEntity(
                    0,
                    todoTitle,
                    description
            )
            mainViewModel.insertToDo(newData)

            Toast.makeText(requireContext(),"Success!!",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_editFragment2_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields!!",Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}