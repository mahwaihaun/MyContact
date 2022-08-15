package my.edu.tarc.mycontact

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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


        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

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
                //navController?.navigate(R.id.action_ContactFragment_to_AddContactFragment)
                 true
            }
        }
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}