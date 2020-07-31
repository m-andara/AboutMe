package com.example.aboutme

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.aboutme.databinding.FragmentHobbyformBinding
import com.example.aboutme.models.Hobby
import com.example.aboutme.repositories.HobbiesRepository
import kotlinx.android.synthetic.main.fragment_hobbyform.*
import kotlinx.android.synthetic.main.item_hobby.*

class HobbyFormFragment(private val onClick: () -> Unit): DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentHobbyformBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit_button.setOnClickListener {
            val title: String = hobby_form_title.editText?.text.toString()
            val desc = hobby_form_desc.editText?.text.toString()
            val hobby = Hobby(title, desc)
            HobbiesRepository.addHobby(hobby)
            onClick()
            dismiss()
        }

    }

}