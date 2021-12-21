package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
    lateinit var navController1: NavController


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
        navController = Navigation.findNavController(view)


        val edt_email = view.findViewById<EditText>(R.id.edt_email)
        val edt_pass = view.findViewById<EditText>(R.id.edt_pass)
        val edt_recpass = view.findViewById<EditText>(R.id.edt_recpass)
        val edt_name = view.findViewById<EditText>(R.id.edt_name)
        val edt_family = view.findViewById<EditText>(R.id.edt_family)
        val edt_phone = view.findViewById<EditText>(R.id.edt_phone)
        val edt_codepost = view.findViewById<EditText>(R.id.edt_codeposti)
        val edt_address = view.findViewById<EditText>(R.id.edt_address)
        val ch_box1 = view.findViewById<CheckBox>(R.id.chbox_1)
        val ch_box2 = view.findViewById<CheckBox>(R.id.chbox_2)
        val rgb = view.findViewById<RadioGroup>(R.id.ac_main_rgb)

        val btn = view.findViewById<Button>(R.id.btn)

        val sp_1 = arrayOf(
            "روز",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30"
        )
        val sp_2 = view.findViewById<Spinner>(R.id.sp_day)
        val sp_adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sp_1)
        sp_2.adapter = sp_adapter1

        val sp_3 = arrayOf("ماه", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
        val sp_4 = view.findViewById<Spinner>(R.id.sp_month)
        val sp_adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sp_3)
        sp_4.adapter = sp_adapter2

        val sp_5 = arrayOf(
            "سال",
            "80",
            "81",
            "82",
            "83",
            "84",
            "85",
            "86",
            "87",
            "88",
            "89",
            "90",
            "91",
            "92",
            "93",
            "94",
            "95",
            "96",
            "97",
            "98",
            "99",
            "1400",
        )
        val sp_6 = view.findViewById<Spinner>(R.id.sp_year)
        val sp_adapter3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sp_5)
        sp_6.adapter = sp_adapter3


        btn.setOnClickListener {

            if (edt_email.text.toString() == "" || edt_pass.text.toString() == "" || edt_recpass.text.toString() == "" ||
                edt_name.text.toString() == "" || edt_family.text.toString() == "" || edt_address.text.toString() == "" || edt_codepost.text.toString() == ""
            ) {
                Toast.makeText(context, "فیلد ها خالی میباشد", Toast.LENGTH_SHORT).show()
            } else if (!edt_phone.text.toString().startsWith("09")) {
                Toast.makeText(context, "شماره موبایل باید از 09 شروع شود", Toast.LENGTH_SHORT)
                    .show()
            } else if (edt_phone.text.toString().length != 11) {
                Toast.makeText(context, "شماره موبایل 11 رقمی است", Toast.LENGTH_SHORT).show()
            } else if (sp_2.selectedItemPosition == 0 && sp_4.selectedItemPosition == 0 && sp_6.selectedItemPosition == 0) {
                Toast.makeText(context, "تاریخ تولد خود را وارد کنید", Toast.LENGTH_SHORT).show()
            } else if (rgb.checkedRadioButtonId == -1) {
                Toast.makeText(context, "جنسیت انتخاب نشده است.", Toast.LENGTH_SHORT).show()
            }
            else if (ch_box1.isChecked && ch_box2.isChecked) {
                val rb=view.findViewById<RadioButton>(rgb.checkedRadioButtonId)


                val bundle1 = bundleOf(
                    "email" to edt_email.text.toString(),
                    "pass" to edt_pass.text.toString(),
                    "phone" to edt_phone.text.toString(),
                    "address" to edt_address.text.toString(),
                    "codeposti" to edt_codepost.text.toString(),
                    "name" to edt_name.text.toString(),
                    "family" to edt_family.text.toString(),
                    "rb" to rb.text.toString(),
                    "sp_2" to sp_2.selectedItemPosition.toString(),
                    "sp_4" to sp_4.selectedItemPosition.toString(),
                    "sp_6" to sp_6.selectedItemPosition.toString()
                )

                navController.navigate(R.id.action_frgme_home_to_frgme_welome, bundle1)


            } else {
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