package my.edu.tarc.mycontact

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import my.edu.tarc.mycontact.databinding.FragmentAddContactBinding


class AddContactFragment : Fragment() {
    private var _binding: FragmentAddContactBinding? = null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.action_save).isVisible = true
        menu.findItem(R.id.action_add).isVisible = false
        menu.findItem(R.id.action_profile).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }
    // For new IDE
    /*override fun onCreateMenu(menu: Menu,menuInflater: MenuInflater){
        menu.findItem((R.id.action_add)).isVisible=false
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                val name = binding.editTextPersonName.text.toString()
                val phone = binding.editTextPhone2.text.toString()
                val newContact  = Contact(name,phone)

                MainActivity.contactList.add(newContact)

                Toast.makeText(context,"Contact Added!",Toast.LENGTH_SHORT).show()

                val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                navController?.navigateUp()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}