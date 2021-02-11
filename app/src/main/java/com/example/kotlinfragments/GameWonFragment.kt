package com.example.kotlinfragments

import android.os.Bundle
import android.content.Context
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kotlinfragments.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false)

        binding.nextMatchButton.setOnClickListener{
            view?.findNavController()?.navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        
       var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        //var args= GameWonFragment.fromBundle(arguments)

        Toast.makeText(context,
        "NumCorrect: $(args.numCorrect), NumQuestions: $(args.numQuestions)",
            Toast.LENGTH_LONG).show()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
    }
}

