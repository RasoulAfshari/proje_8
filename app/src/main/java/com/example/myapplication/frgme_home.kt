package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [frgme_home.newInstance] factory method to
 * create an instance of this fragment.
 */
class frgme_home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frgme_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController= Navigation.findNavController(view)
        var edt_email = view.findViewById<EditText>(R.id.edt_email)
        var edt_pass = view.findViewById<EditText>(R.id.edt_pass)
        var edt_recpass = view.findViewById<EditText>(R.id.edt_recpass)
        var edt_phone = view.findViewById<EditText>(R.id.edt_phone)
        var edt_codepost = view.findViewById<EditText>(R.id.edt_codeposti)
        var edt_address = view.findViewById<EditText>(R.id.edt_address)
        val ch_box=view.findViewById<CheckBox>(R.id.chbox)
        val btn=view.findViewById<Button>(R.id.btn)

        btn.setOnClickListener {

            if(!edt_phone.text.toString().startsWith("09")){
                Toast.makeText(context, "شماره موبایل باید از 09 شروع شود", Toast.LENGTH_SHORT).show()
        }
            else if(edt_phone.text.toString().length!=11){
                Toast.makeText(context, "شماره موبایل 11 رقمی است", Toast.LENGTH_SHORT).show()
        }
           else if (edt_email.text.toString()=="" || edt_pass.text.toString()==""||edt_recpass.text.toString()==""||
                edt_address.text.toString()=="" || edt_codepost.text.toString()==""){
                Toast.makeText(context, "فیلد ها خالی میباشد", Toast.LENGTH_SHORT).show()
           }
            if (ch_box.isChecked){

                val bundle= bundleOf("email" to edt_email.text.toString())
                val bundle2= bundleOf("pass" to edt_pass.text.toString())
                val bundle3= bundleOf("phone" to edt_phone.text.toString())
                val bundle4= bundleOf("address" to edt_address.text.toString())
                val bundle5= bundleOf("codeposti" to edt_address.text.toString())

                navController.navigate(R.id.action_frgme_home_to_frgme_welome,bundle)

            }
            else{
                Toast.makeText(context, "تایید قوانین!!", Toast.LENGTH_SHORT).show()
            }
        }




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment frgme_home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            frgme_home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}