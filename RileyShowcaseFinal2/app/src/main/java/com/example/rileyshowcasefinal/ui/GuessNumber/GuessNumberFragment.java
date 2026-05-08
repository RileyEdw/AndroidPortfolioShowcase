package com.example.rileyshowcasefinal.ui.GuessNumber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rileyshowcasefinal.R;
import com.example.rileyshowcasefinal.databinding.FragmentGuessnumberBinding;

import java.util.Random;

public class GuessNumberFragment extends Fragment {

    private FragmentGuessnumberBinding binding;
    private int targetNumber;
    private int points;
    private int guessesLeft;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGuessnumberBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resetGame();

        binding.guessButton.setOnClickListener(v -> handleGuess());
        binding.playAgainButton.setOnClickListener(v -> resetGame());
    }

    private void resetGame() {
        Random randy = new Random();
        targetNumber = randy.nextInt(100) + 1;
        guessesLeft = 10;
        points = 0;

        binding.liveRiley.setImageResource(R.drawable.thinkriley);
        binding.textGallery.setText("I'm thinking of a number between 1 and 100\nYou have 10 Guesses.");
        binding.feedbackText.setText("");
        binding.guessInput.setText("");
        binding.guessInput.setEnabled(true);
        binding.guessButton.setEnabled(true);
        binding.playAgainButton.setVisibility(View.GONE);
    }

    private void handleGuess() {
        String guessString = binding.guessInput.getText().toString();
        if (guessString.isEmpty()) {
            Toast.makeText(getContext(), "Enter a number to guess.", Toast.LENGTH_SHORT).show();
            return;
        }

        int guess = Integer.parseInt(guessString);
        guessesLeft-=1;

        if (guess < targetNumber) {
            binding.feedbackText.setText("Too low. Guess Higher.");
            binding.liveRiley.setImageResource(R.drawable.upriley);
            binding.textGallery.setText("I'm thinking of a number between 1 and 100\nYou have "+guessesLeft+" Guesses.");
        } else if (guess > targetNumber) {
            binding.feedbackText.setText("Too high. Guess Lower.");
            binding.liveRiley.setImageResource(R.drawable.downriley);
            binding.textGallery.setText("I'm thinking of a number between 1 and 100\nYou have "+guessesLeft+" Guesses.");
        } else {
            binding.feedbackText.setText("Correct! You earned "+(50+(5*guessesLeft))+" points!");
            points+=(50+(5*guessesLeft));
            binding.pointsView.setText("Current Points: "+points);
            binding.liveRiley.setImageResource(R.drawable.winriley);
            guessesLeft = 10;
            binding.textGallery.setText("I'm thinking of a NEW number between 1 and 100\nYou have "+guessesLeft+" Guesses.");
            Random randy = new Random();
            targetNumber = randy.nextInt(100) + 1;

        }
        binding.guessInput.setText("");
        if (guessesLeft == 0) {
            binding.feedbackText.setText("The number was "+targetNumber+".");
            binding.liveRiley.setImageResource(R.drawable.loseriley);
            binding.textGallery.setText("GAME OVER");
            binding.guessInput.setEnabled(false);
            binding.guessButton.setEnabled(false);
            binding.playAgainButton.setVisibility(View.VISIBLE);
        }
        else if (guessesLeft == 1) {
            binding.textGallery.setText("I'm thinking of a number between 1 and 100\nLAST GUESS.");
            binding.liveRiley.setImageResource(R.drawable.gulpriley);}
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();
        //This is here to clear the editTexts when the user comes back.
        binding.guessInput.setText("");
        resetGame();
    }
}
