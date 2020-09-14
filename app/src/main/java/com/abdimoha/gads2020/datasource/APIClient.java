package com.abdimoha.gads2020.datasource;

import com.abdimoha.gads2020.model.SkillIQ;
import com.abdimoha.gads2020.model.TopLearner;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private APIInterface APIInterface;
    private static APIClient INSTANCE;

    public APIClient() {
// Build Retrofit
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface = retrofit.create(APIInterface.class);
    }


    //Singleton
    public static APIClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new APIClient();
        }
        return INSTANCE;
    }

    public Call<List<SkillIQ>> getTopSkill() {
        return APIInterface.getTopSkill();
    }

    public Call<List<TopLearner>> getTopLearners() {
        return APIInterface.getTopLearners();
    }
}
