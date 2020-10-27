package com.ramasolutions.petagramins.RestApi;

import com.ramasolutions.petagramins.model.BioResponse;
import com.ramasolutions.petagramins.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsAPI {

    @GET(com.ramasolutions.petagramins.RestApi.ConstantsRestApi.URL_USER_MEDIA)
    Call<PetResponse> getRecentMedia();

    @GET(com.ramasolutions.petagramins.RestApi.ConstantsRestApi.URL_USER_BIO)
    Call<BioResponse> getBioInfo();
}
