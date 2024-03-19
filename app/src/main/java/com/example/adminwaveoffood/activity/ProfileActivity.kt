package com.example.adminwaveoffood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminwaveoffood.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding:ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        binding.etName.isEnabled=false
        binding.etAddress.isEnabled=false
        binding.etEmail.isEnabled=false
        binding.etPhone.isEnabled=false
        binding.etPassword.isEnabled=false
        var isEnable=false

        binding.tvEditText.setOnClickListener{
          isEnable = !isEnable
            binding.etName.isEnabled=isEnable
            binding.etAddress.isEnabled=isEnable
            binding.etEmail.isEnabled=isEnable
            binding.etPhone.isEnabled=isEnable
            binding.etPassword.isEnabled=isEnable

            if(isEnable){
                binding.etName.requestFocus()
            }
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}