package com.jonasrosendo.aprendaingles.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jonasrosendo.aprendaingles.R;
import com.jonasrosendo.aprendaingles.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imgb_cao, imgb_gato, imgb_leao, imgb_macaco, imgb_ovelha, imgb_vaca;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imgb_cao = view.findViewById(R.id.imgb_cao);
        imgb_gato = view.findViewById(R.id.imgb_gato);
        imgb_leao = view.findViewById(R.id.imgb_leao);
        imgb_macaco = view.findViewById(R.id.imgb_macaco);
        imgb_ovelha = view.findViewById(R.id.imgb_ovelha);
        imgb_vaca = view.findViewById(R.id.imgb_vaca);

        imgb_cao.setOnClickListener(this);
        imgb_gato.setOnClickListener(this);
        imgb_leao.setOnClickListener(this);
        imgb_macaco.setOnClickListener(this);
        imgb_ovelha.setOnClickListener(this);
        imgb_vaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgb_cao:
                playSong(R.raw.dog);
                break;
            case R.id.imgb_gato:
                playSong(R.raw.cat);
                break;
            case R.id.imgb_leao:
                playSong(R.raw.lion);
                break;
            case R.id.imgb_macaco:
                playSong(R.raw.monkey);
                break;
            case R.id.imgb_ovelha:
                playSong(R.raw.sheep);
                break;
            case R.id.imgb_vaca:
                playSong(R.raw.cow);
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
