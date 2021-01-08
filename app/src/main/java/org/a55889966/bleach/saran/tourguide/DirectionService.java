package org.a55889966.bleach.saran.tourguide;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DirectionService {

    @GET
    Call<DirectionResponse>getDirections(@Url String urlString);
}
