package com.vibhu.devcomm.navigationcomponentdemo


import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

//import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var input_recipient:TextInputEditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_recipient = view.findViewById<TextInputEditText>(R.id.input_recipient)
        input_recipient.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("#### ChooseRecipientFragment","View got clicked")
        when(v!!.id){
            R.id.next_btn -> {
                Log.d("#### ChooseRecipientFragment","TextInputEditText ke andar aa gaye")
                if(!TextUtils.isEmpty(input_recipient.text.toString())){
                    val bundle = bundleOf("recipient" to input_recipient.text.toString())
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }
}
