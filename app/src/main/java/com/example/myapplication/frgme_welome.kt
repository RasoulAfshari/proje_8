package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [frgme_welome.newInstance] factory method to
 * create an instance of this fragment.
 */
class frgme_welome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var email:String=""
    private var pass:String=""
    private var phone:String=""
    private var address:String=""
    private var codeposti:String=""
    private var name:String=""
    private var family:String=""
    private var rb:String=""
    private var sp_2:String=""
    private var sp_4:String=""
    private var sp_6:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
        email = requireArguments().getString("email").toString()
        pass = requireArguments().getString("pass").toString()
        phone = requireArguments().getString("phone").toString()
        address = requireArguments().getString("address").toString()
        codeposti = requireArguments().getString("codeposti").toString()
        name = requireArguments().getString("name").toString()
        family = requireArguments().getString("family").toString()
        rb = requireArguments().getString("rb").toString()
        sp_2 = requireArguments().getString("sp_2").toString()
        sp_4 = requireArguments().getString("sp_4").toString()
        sp_6 = requireArguments().getString("sp_6").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frgme_welome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tv_email=view.findViewById<TextView>(R.id.tv_email)
        tv_email.text=email

        val tv_pass=view.findViewById<TextView>(R.id.tv_pass)
        tv_pass.text=pass

        val tv_phone=view.findViewById<TextView>(R.id.tv_phone)
        tv_phone.text=phone

        val tv_address=view.findViewById<TextView>(R.id.tv_codeposti)
        tv_address.text=address

        val tv_codeposti=view.findViewById<TextView>(R.id.tv_address)
        tv_codeposti.text=codeposti

        val tv_name=view.findViewById<TextView>(R.id.tv_name)
        tv_name.text=name

        val tv_family=view.findViewById<TextView>(R.id.tv_family)
        tv_family.text=family

        val tv_rgb=view.findViewById<TextView>(R.id.tv_rgb)
        tv_rgb.text=rb

        val tv_sp_2=view.findViewById<TextView>(R.id.tv_day)
        tv_sp_2.text=sp_2

        val tv_sp_4=view.findViewById<TextView>(R.id.tv_month)
        tv_sp_4.text=sp_4

        val tv_sp_6=view.findViewById<TextView>(R.id.tv_year)
        tv_sp_6.text=sp_6
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment frgme_welome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            frgme_welome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}