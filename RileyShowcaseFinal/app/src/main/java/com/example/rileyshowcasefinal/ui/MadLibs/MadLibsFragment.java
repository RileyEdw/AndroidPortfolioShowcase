package com.example.rileyshowcasefinal.ui.MadLibs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.rileyshowcasefinal.databinding.FragmentMadlibsBinding;

public class MadLibsFragment extends Fragment {

    private FragmentMadlibsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMadlibsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int[] whichStory = {3}; //0 is the park, 1 is the magic, 2 is the space.

        binding.parkBTN.setOnClickListener(v -> {
            whichStory[0] = 0;
            menuToSelection("A Day in the Park");
        });

        binding.magicBTN.setOnClickListener(v -> {
            whichStory[0] = 1;
            menuToSelection("The Magical Discovery");
        });

        binding.spaceBTN.setOnClickListener(v -> {
            whichStory[0] = 2;
            menuToSelection("Space Mission Gone Wrong");
        });

        binding.randomBTN.setOnClickListener(v -> {
            Random randy = new Random();
            whichStory[0] = randy.nextInt(3);
            menuToSelection("Let's see what happens!");
        });

        binding.generatorBTN.setOnClickListener(v -> {
            String name = binding.nameTXT.getText().toString();
            binding.nameTXT.setText("");
            String place = binding.placeTXT.getText().toString();
            binding.placeTXT.setText("");
            String noun = binding.nounTXT.getText().toString();
            binding.nounTXT.setText("");
            String adjective = binding.adjectiveTXT.getText().toString();
            binding.adjectiveTXT.setText("");
            String verb = binding.verbTXT.getText().toString();
            binding.verbTXT.setText("");
            String animal = binding.animalTXT.getText().toString();
            binding.animalTXT.setText("");
            String silly = binding.sillyTXT.getText().toString();
            binding.sillyTXT.setText("");
            String object = binding.objectTXT.getText().toString();
            binding.objectTXT.setText("");

            binding.selectionLayout.setVisibility(View.INVISIBLE);
            binding.storyLayout.setVisibility(View.VISIBLE);

            String story;
            if (whichStory[0] == 0) {
                story = "Yesterday, " + name + " went to the " + place + " to feed the " + noun + ".\n" +
                        " It was a " + adjective + " afternoon. Suddenly, someone " + verb + " right next to a " + animal + ", yelling \"" + silly + "!\"\n" +
                        " Startled, " + name + " dropped their " + object + " and ran away laughing.";
            } else if (whichStory[0] == 1) {
                story = "Once upon a time, " + name + " found a hidden map in " + place + ".\n" +
                        " It led to a cave filled with glowing " + noun + ".\n" +
                        " With a " + adjective + " heart, " + name + " " + verb + " forward, only to find a talking " + animal + " who only said \"" + silly + "\".\n" +
                        " The treasure? A magical " + object + " that could turn invisible.";
            } else { // whichStory[0] == 2
                story = "Captain " + name + " blasted off from " + place + " with a crew of robotic " + noun + ".\n" +
                        " Their mission: explore the " + adjective + " planet Zorgon.\n" +
                        " But things went sideways when a giant " + animal + " appeared and " + verb + " the spaceship while shouting \"" + silly + "!\"\n" +
                        " Luckily, " + name + " escaped using a backup " + object + ".";
            }
            binding.storyTextView.setText(story);
        });

        binding.returnBTN.setOnClickListener(v -> {
            binding.menuLayout.setVisibility(View.VISIBLE);
            binding.storyLayout.setVisibility(View.INVISIBLE);
        });
    }

    public void menuToSelection(String story) {
        binding.selectionTitle.setText(story);
        binding.menuLayout.setVisibility(View.INVISIBLE);
        binding.selectionLayout.setVisibility(View.VISIBLE);
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
        binding.nameTXT.setText("");
        binding.placeTXT.setText("");
        binding.nounTXT.setText("");
        binding.adjectiveTXT.setText("");
        binding.animalTXT.setText("");
        binding.verbTXT.setText("");
        binding.sillyTXT.setText("");
        binding.objectTXT.setText("");
    }
}
