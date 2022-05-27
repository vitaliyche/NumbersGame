package com.codeliner.numbersgame.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.codeliner.numbersgame.R
import com.codeliner.numbersgame.databinding.FragmentGameFinishBinding
import com.codeliner.numbersgame.domain.entity.GameResult

class GameFinishFragment : Fragment() {

    private val args by navArgs<GameFinishFragmentArgs>()

    private var _binding: FragmentGameFinishBinding? = null
    private val binding: FragmentGameFinishBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners() //после завершения игры, при нажатии кнопки назад, перейти на экран выбора уровня
        bindViews()
    }

    private fun setupClickListeners() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun bindViews() {
        with(binding) {
            emojiResult.setImageResource(getSmileResId())
            tvRequiredAnswers.text = String.format(
                getString(R.string.required_score),
                args.gameResult.gameSettings.minCountofRightAnswers
            )
            tvScoreAnswers.text = String.format(
                getString(R.string.score_answers),
                args.gameResult.countOfRightAnswers
            )
            tvRequiredPercentage.text = String.format(
                getString(R.string.required_percentage),
                args.gameResult.gameSettings.minPercentOfRightAnswers //получить необходимое количество процентов
            )
            tvScorePercentage.text = String.format(
                getString(R.string.score_percentage),
                getPercentOfRightAnswers() //получить процент правильных ответов
            )
        }
    }

    private fun getSmileResId(): Int {
        return if (args.gameResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    private fun getPercentOfRightAnswers() = with(args.gameResult) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers/countOfQuestions.toDouble())*100).toInt()
        } // делить количество правильных ответов на количество вопросов
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }
}