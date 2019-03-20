package com.jonasrosendo.aprendaingles.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jonasrosendo.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imgb_um, imgb_dois, imgb_tres, imgb_quatro, imgb_cinco, imgb_seis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imgb_um = view.findViewById(R.id.imgb_um);
        imgb_dois = view.findViewById(R.id.imgb_dois);
        imgb_tres = view.findViewById(R.id.imgb_tres);
        imgb_quatro = view.findViewById(R.id.imgb_quatro);
        imgb_cinco = view.findViewById(R.id.imgb_cinco);
        imgb_seis = view.findViewById(R.id.imgb_seis);


        imgb_um.setOnClickListener(this);
        imgb_dois.setOnClickListener(this);
        imgb_tres.setOnClickListener(this);
        imgb_quatro.setOnClickListener(this);
        imgb_cinco.setOnClickListener(this);
        imgb_seis.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imgb_um:
                playSong(R.raw.one);
                break;

            case R.id.imgb_dois:
                playSong(R.raw.two);
                break;

            case R.id.imgb_tres:
                playSong(R.raw.three);
                break;

            case R.id.imgb_quatro:
                playSong(R.raw.four);
                break;

            case R.id.imgb_cinco:
                playSong(R.raw.five);
                break;

            case R.id.imgb_seis:
                playSong(R.raw.six);
                break;
        }
    }

    public void playSong(int song){
        mediaPlayer = MediaPlayer.create(getActivity(), song);

        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}
