package com.dunbar.daniel.latenz.colorpicker.builder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dunbar.daniel.latenz.R;
import com.dunbar.daniel.latenz.colorpicker.ColorPickerView;
import com.dunbar.daniel.latenz.colorpicker.OnColorChangedListener;
import com.dunbar.daniel.latenz.colorpicker.OnColorSelectedListener;
import com.dunbar.daniel.latenz.colorpicker.Utils;
import com.dunbar.daniel.latenz.colorpicker.renderer.ColorWheelRenderer;
import com.dunbar.daniel.latenz.colorpicker.slider.AlphaSlider;
import com.dunbar.daniel.latenz.colorpicker.slider.LightnessSlider;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ColorPickerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ColorPickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorPickerFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public ColorPickerFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ColorPickerFragment newInstance(int sectionNumber) {
        ColorPickerFragment fragment = new ColorPickerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_color_picker, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setOnFragmentInteractionListener(OnFragmentInteractionListener listener){
        mListener = listener;
    }

    public interface OnFragmentInteractionListener{
        public void onColorSelected();
    }
}
