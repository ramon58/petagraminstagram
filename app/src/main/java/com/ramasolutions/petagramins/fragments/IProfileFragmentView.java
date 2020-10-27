package com.ramasolutions.petagramins.fragments;

import com.ramasolutions.petagramins.adapter.ProfileAdapter;
import com.ramasolutions.petagramins.pojo.BioItem;
import com.ramasolutions.petagramins.pojo.ProfileItem;

import java.util.ArrayList;

public interface IProfileFragmentView {

    public void generateGridLayout();
    public ProfileAdapter createAdapter(ArrayList<ProfileItem> profileItems);
    public void initializeAdapter(ProfileAdapter profileAdapter);
    public void showProfile(BioItem bioItem);
}
