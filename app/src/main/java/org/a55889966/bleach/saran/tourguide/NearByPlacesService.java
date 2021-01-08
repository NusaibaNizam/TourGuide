package org.a55889966.bleach.saran.tourguide;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NearByPlacesService {

    @GET
    Call<NearByPlacesResponse>getNearByPlaces(@Url String urlString);
}
