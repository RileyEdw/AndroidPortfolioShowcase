package com.example.rileyshowcasefinal.ui.Doodle;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rileyshowcasefinal.databinding.FragmentDoodleBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DoodleFragment extends Fragment {

    private FragmentDoodleBinding binding;

    private int redness = 0;
    private int greenness = 0;
    private int blueness = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDoodleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        redness = (int) binding.sliderRed.getValue();
        greenness = (int) binding.sliderGreen.getValue();
        blueness = (int) binding.sliderBlue.getValue();
        updatePaintColor();

        binding.sliderRed.addOnChangeListener((slider, value, fromUser) -> {
            redness = (int) value;
            updatePaintColor();
        });

        binding.sliderGreen.addOnChangeListener((slider, value, fromUser) -> {
            greenness = (int) value;
            updatePaintColor();
        });

        binding.sliderBlue.addOnChangeListener((slider, value, fromUser) -> {
            blueness = (int) value;
            updatePaintColor();
        });

        binding.eraser.setOnClickListener(v -> {
            binding.drawView.clearCanvas();
        });
        binding.buttonSave.setOnClickListener(v -> {
        }
    }

    private void updatePaintColor() {
        int color = Color.rgb(redness, greenness, blueness);
        binding.drawView.repaint(color);
        binding.colorPreview.setBackgroundColor(color);
        Log.d("DoodleFragment", String.format("Color updated to: RGB(%d, %d, %d)", redness, greenness, blueness));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
