package com.ramasolutions.petagramins.RestApi.adapter;

import com.ramasolutions.petagramins.RestApi.ConstantsRestApi;
import com.ramasolutions.petagramins.RestApi.EndpointsAPI;
import com.ramasolutions.petagramins.RestApi.deserializador.BioDeserializer;
import com.ramasolutions.petagramins.RestApi.deserializador.PetDeserializador;
import com.ramasolutions.petagramins.model.BioResponse;
import com.ramasolutions.petagramins.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsAPI stablishConnectionRestAPInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsAPI.class);
    }

    public Gson buildGsonDeserializeMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());
        return gsonBuilder.create();
    }

    public Gson builGsonDeserializerBioInfo() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BioResponse.class, new BioDeserializer());
        return gsonBuilder.create();
    }
}
