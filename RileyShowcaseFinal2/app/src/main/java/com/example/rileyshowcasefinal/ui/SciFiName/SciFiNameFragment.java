package com.example.rileyshowcasefinal.ui.SciFiName;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rileyshowcasefinal.databinding.FragmentScifinameBinding;

public class SciFiNameFragment extends Fragment {

    private FragmentScifinameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScifinameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.generateBTN.setOnClickListener(v -> {
            String fname = binding.firstTXT.getText().toString().trim();
            String lname = binding.lastTXT.getText().toString().trim();
            String city = binding.cityTXT.getText().toString().trim();
            String school = binding.schoolTXT.getText().toString().trim();
            String petorfood = binding.petorfoodTXT.getText().toString().trim();
            String person = binding.personTXT.getText().toString().trim();

            if (fname.length() < 2 || lname.length() < 3 || city.length() < 2 || school.length() < 3) {
                Toast.makeText(getContext(), "Make sure everything is filled out.", Toast.LENGTH_SHORT).show();
                return;
            }

            String firstpart1 = fname.substring(0, 2);
            String firstpart2 = lname.substring(0, 3);
            String first = firstpart1 + firstpart2;

            String lastpart1 = city.substring(0, 2);
            String lastpart2 = school.substring(0, 3);
            String last = lastpart1 + lastpart2;

            String sciFiName = "Hello, " + first + " " + last + " from the planet " + petorfood + " " + person + " !";
            binding.product.setText(sciFiName);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //This is here to clear the editTexts when the user comes back.
        binding.firstTXT.setText("");
        binding.lastTXT.setText("");
        binding.cityTXT.setText("");
        binding.schoolTXT.setText("");
        binding.petorfoodTXT.setText("");
        binding.personTXT.setText("");
        binding.product.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
