package com.nusantarian.halopet.fragment.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.nusantarian.halopet.R
import com.nusantarian.halopet.activity.MainActivity
import com.nusantarian.halopet.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.btnRegister.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_register){
            val email = binding.tilEmail.editText?.text.toString()
            val pass = binding.tilPass.editText?.text.toString()
            val name = binding.tilName.editText?.text.toString()
            val confirm = binding.tilConfirm.editText?.text.toString()
            binding.progress.visibility = View.VISIBLE

            if (!isValid(email, pass, name, confirm)){
                binding.progress.visibility = View.GONE
            } else {
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(activity!!, "Welcome to Halo-Pet!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(activity!!, MainActivity::class.java))
                        activity!!.finish()
                    } else {
                        Toast.makeText(activity!!, "Failed to Register", Toast.LENGTH_SHORT).show()
                    }
                    binding.progress.visibility = View.GONE
                }.addOnFailureListener {
                    Toast.makeText(activity!!, it.message, Toast.LENGTH_SHORT).show()
                    binding.progress.visibility = View.GONE
                }
            }
        }
    }

    private fun isValid(email : String, pass: String, name: String, confirm: String) : Boolean {
        return if (email.isEmpty() || pass.isEmpty() || name.isEmpty()){
            binding.tilEmail.error = "Empty Field"
            binding.tilPass.error = "Empty Field"
            binding.tilName.error = "Empty Field"
            false
        }
        else if (pass != confirm){
            binding.tilConfirm.error = "Password Didn't Match"
            binding.tilPass.error = "Password Didn't Match"
            false
        } else {
            binding.tilEmail.error = null
            binding.tilPass.error = null

            binding.tilEmail.isErrorEnabled
            binding.tilPass.isErrorEnabled
            true
        }
    }
}