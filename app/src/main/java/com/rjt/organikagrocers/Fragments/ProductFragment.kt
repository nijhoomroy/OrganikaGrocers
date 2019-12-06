package com.rjt.organikagrocers.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.rjt.organikagrocers.Adapters.ProductListAdapter
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.Models.ProductModelList

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import kotlinx.android.synthetic.main.fragment_product.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ProductFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    //private var listener: OnFragmentInteractionListener? = null

    lateinit var adapter2: ProductListAdapter
    var list: ArrayList<ProductModel>  = ArrayList<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_product, container, false)

        getdata()

        view.product_list_recycler_view.layoutManager = GridLayoutManager(this.activity, 2)
        adapter2 = ProductListAdapter(this.activity!!, list)
        view.product_list_recycler_view.adapter = adapter2



        return view
    }

    private fun getdata() {
        val url: String = "http://rjtmobile.com/grocery/products.json"
        var filteredData = ArrayList<ProductModel>()
        var requestQueue = Volley.newRequestQueue(this.activity)
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener { response ->
                val gson = GsonBuilder().create()
                val data: ProductModelList = gson.fromJson(response.toString(), ProductModelList::class.java)

                for((index, product: ProductModel) in data.data.withIndex()){
                    if(data.data.get(index).subId == param1){
                        filteredData.add(product)
                    }}


                    adapter2?.setData(filteredData)

                view?.progress_bar?.visibility = View.GONE
            },
                Response.ErrorListener { Toast.makeText(this.activity, it.message, Toast.LENGTH_SHORT).show() })

        requestQueue.add(stringRequest)

    }

    // TODO: Rename method, update argument and hook method into UI event
   /* fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}
