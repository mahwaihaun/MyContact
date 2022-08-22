package my.edu.tarc.mycontact

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import my.edu.tarc.mycontact.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ContactFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Enable menu item
        setHasOptionsMenu(true)
        //Only needed for new IDE
        //val menuHost: MenuHost = requireActivity()
        //menuHost.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)

        Log.d("onCreateView","First Fragment")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart(){
        Log.d("onResume","First Fragment")
        super.onStart()
    }

    override fun onResume(){
        Log.d("onResume","First Fragment")
        super.onResume()

        val contactAdapter = ContactAdapter(MainActivity.contactList)
        binding.recyclerViewContact.layoutManager = LinearLayoutManager(activity?.applicationContext)
        binding.recyclerViewContact.adapter = contactAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem((R.id.action_save)).isVisible=false

    }

    // For new IDE
    /*override fun onCreateMenu(menu: Menu,menuInflater: MenuInflater){
        menu.findItem((R.id.action_save)).isVisible=false
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_profile ->{
                val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                navController?.navigate(R.id.action_ContactFragment_to_ProfileFragment)
                 true
            }
            R.id.action_add->{
                val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                navController?.navigate(R.id.action_ContactFragment_to_addContactFragment)
                 true
            }
        }
        return true
    }

    override fun onDestroyView() {
        Log.d("onDestroy","First Fragment")
        super.onDestroyView()
        _binding = null
    }
}