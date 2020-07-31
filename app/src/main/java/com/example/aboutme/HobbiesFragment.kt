package com.example.aboutme

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutme.adapters.HobbiesAdapter
import com.example.aboutme.repositories.HobbiesRepository
import kotlinx.android.synthetic.main.fragment_hobbies.*
import kotlin.math.log

class HobbiesFragment: Fragment(R.layout.fragment_hobbies) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apply {
            val adapter = HobbiesAdapter(HobbiesRepository.getHobbies())
            hobbies_list.adapter = adapter
            hobbies_list.layoutManager = LinearLayoutManager(this.context)

            val hobbyForm = HobbyFormFragment() {
                (hobbies_list.adapter as HobbiesAdapter).notifyDataSetChanged()
            }

            add_hobby_fab.setOnClickListener {
                val manager = activity?.supportFragmentManager
                hobbyForm.show(manager!!, "Hobby Form")
            }
        }
    }

}