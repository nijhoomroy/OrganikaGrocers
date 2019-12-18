package com.rjt.organikagrocers.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rjt.organikagrocers.Activity.HomeActivity

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrderFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    //private var param1: String? = null

    //private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_order, container, false)

        val myPref:SharedPreferences = activity!!.getSharedPreferences("myPref", Context.MODE_PRIVATE)

        var subtotal = myPref.getFloat("subtotal", 0.0f)


        view.text_view_subtotal.text = "$ " + subtotal

        var taxes = (subtotal)*0.10
        var shipping = 9.99
        var total = (subtotal) + taxes + shipping

        view.text_view_taxes.text = "$%.2f ".format(taxes)
        view.text_view_shipping.text = "$ " + shipping
        view.text_view_total.text = "$%.2f ".format(total)

        view.btn_complete.setOnClickListener{

            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)

            Toast.makeText(activity, "Order places successfully!", Toast.LENGTH_LONG).show()
        }



        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
   /* fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/

   /* override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }*/

    /*override fun onDetach() {
        super.onDetach()
        listener = null
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
   /* interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }*/


}
